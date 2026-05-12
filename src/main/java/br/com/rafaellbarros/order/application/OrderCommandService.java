package br.com.rafaellbarros.order.application;

import br.com.rafaellbarros.core.product.model.Product;
import br.com.rafaellbarros.core.product.repository.ProductRepository;
import br.com.rafaellbarros.user.User;
import br.com.rafaellbarros.user.UserRepository;
import br.com.rafaellbarros.integration.invetory.InventoryClient;
import br.com.rafaellbarros.integration.payment.PaymentClient;
import br.com.rafaellbarros.order.application.dto.OrderItemInput;
import br.com.rafaellbarros.order.application.dto.PaymentRequest;
import br.com.rafaellbarros.order.domain.Order;
import br.com.rafaellbarros.order.domain.OrderItem;
import br.com.rafaellbarros.order.domain.OrderStatus;
import br.com.rafaellbarros.order.domain.exception.OrderBusinessException;
import br.com.rafaellbarros.order.events.OrderCreatedEvent;
import br.com.rafaellbarros.order.events.OrderPaidEvent;
import br.com.rafaellbarros.order.infrastructure.OrderRepository;
import br.com.rafaellbarros.order.infrastructure.OrderValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class OrderCommandService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final OrderValidator validator;
    private final PaymentClient paymentClient;
    private final InventoryClient inventoryClient;
    private final ApplicationEventPublisher eventPublisher;

    public Order createOrder(UUID userId, List<OrderItemInput> items) {
        log.info("Creating order for user: {}", userId);

        // Validar usuário
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new OrderBusinessException("User not found with id: " + userId, "USER_NOT_FOUND"));

        // Validar itens do pedido
        validator.validateOrderItems(items);

        // Criar pedido
        Order order = new Order();
        order.setUser(user);
        order.setStatus(OrderStatus.PENDING);
        order.setTotal(BigDecimal.ZERO);

        // Processar itens
        BigDecimal total = processOrderItems(order, items);
        order.setTotal(total);

        // Salvar pedido
        Order savedOrder = orderRepository.save(order);

        // Reservar estoque no inventory-service
        inventoryClient.reserveStock(savedOrder.getId(), items);

        // Publicar evento
        eventPublisher.publishEvent(new OrderCreatedEvent(savedOrder.getId(), userId));

        log.info("Order created successfully: {}", savedOrder.getId());
        return savedOrder;
    }

    private BigDecimal processOrderItems(Order order, List<OrderItemInput> items) {
        BigDecimal total = BigDecimal.ZERO;

        for (OrderItemInput input : items) {
            Product product = productRepository.findById(input.getProductId())
                    .orElseThrow(() -> new OrderBusinessException(
                            "Product not found: " + input.getProductId(),
                            "PRODUCT_NOT_FOUND"
                    ));

            // Validar estoque
            if (product.getStock() < input.getQuantity()) {
                throw new OrderBusinessException(
                        String.format("Insufficient stock for product '%s'. Available: %d, Requested: %d",
                                product.getName(), product.getStock(), input.getQuantity()),
                        "INSUFFICIENT_STOCK"
                );
            }

            // Criar item
            OrderItem item = new OrderItem();
            item.setOrder(order);
            item.setProduct(product);
            item.setQuantity(input.getQuantity());
            item.setPrice(product.getPrice());

            order.getItems().add(item);

            // Calcular subtotal
            BigDecimal subtotal = product.getPrice().multiply(BigDecimal.valueOf(input.getQuantity()));
            total = total.add(subtotal);

            // Atualizar estoque local
            product.setStock(product.getStock() - input.getQuantity());
            productRepository.save(product);
        }

        return total;
    }

    public Order processPayment(Long orderId, PaymentRequest paymentRequest) {
        log.info("Processing payment for order: {}", orderId);

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderBusinessException("Order not found: " + orderId, "ORDER_NOT_FOUND"));

        // Validar status do pedido
        validator.validatePaymentEligibility(order);

        // Processar pagamento via payment-service
        var paymentResponse = paymentClient.processPayment(orderId, paymentRequest);

        if (paymentResponse.success()) {
            order.setStatus(OrderStatus.CONFIRMED);
            orderRepository.save(order);

            // Publicar evento de pagamento aprovado
            eventPublisher.publishEvent(new OrderPaidEvent(orderId, paymentResponse.transactionId()));

            log.info("Payment approved for order: {}", orderId);
        } else {
            order.setStatus(OrderStatus.CANCELLED);
            orderRepository.save(order);
            log.warn("Payment failed for order: {}", orderId);
        }

        return order;
    }

    public Order cancelOrder(Long orderId, String reason) {
        log.info("Cancelling order: {} due to: {}", orderId, reason);

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderBusinessException("Order not found: " + orderId, "ORDER_NOT_FOUND"));

        // Verificar se pode cancelar
        validator.validateCancellation(order);

        order.setStatus(OrderStatus.CANCELLED);

        // Restaurar estoque
        for (OrderItem item : order.getItems()) {
            Product product = item.getProduct();
            product.setStock(product.getStock() + item.getQuantity());
            productRepository.save(product);
        }

        Order cancelledOrder = orderRepository.save(order);

        log.info("Order cancelled successfully: {}", orderId);
        return cancelledOrder;
    }
}