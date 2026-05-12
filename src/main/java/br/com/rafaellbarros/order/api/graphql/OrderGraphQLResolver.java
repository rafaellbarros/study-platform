package br.com.rafaellbarros.order.api.graphql;

import br.com.rafaellbarros.order.application.OrderCommandService;
import br.com.rafaellbarros.order.application.OrderQueryService;
import br.com.rafaellbarros.order.application.dto.OrderItemInput;
import br.com.rafaellbarros.order.application.dto.PaymentRequest;
import br.com.rafaellbarros.order.domain.Order;
import br.com.rafaellbarros.order.domain.OrderStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Slf4j
@Controller
@RequiredArgsConstructor
public class OrderGraphQLResolver {

    private final OrderCommandService orderCommandService;
    private final OrderQueryService orderQueryService;

    @QueryMapping
    public List<Order> orders(@Argument UUID userId) {
        log.info("GraphQL Query: orders - userId: {}", userId);

        if (userId != null) {
            return orderQueryService.findByUserId(userId);
        }
        return orderQueryService.findAll();
    }

    @QueryMapping
    public Order order(@Argument Long id) {
        log.info("GraphQL Query: order - id: {}", id);
        return orderQueryService.findById(id);
    }

    @QueryMapping
    public List<Order> ordersByStatus(@Argument String status) {
        log.info("GraphQL Query: ordersByStatus - status: {}", status);
        // TODO: Implementar busca por status
        return orderQueryService.findByStatus(OrderStatus.valueOf(status));
    }

    // ========== MUTATIONS ==========

    @MutationMapping
    public Order createOrder(@Argument CreateOrderInput input) {
        log.info("GraphQL Mutation: createOrder - userId: {}, items: {}",
                input.userId(), input.items().size());

        List<OrderItemInput> items = input.items().stream()
                .map(item -> new OrderItemInput(item.productId(), item.quantity()))
                .toList();

        return orderCommandService.createOrder(input.userId(), items);
    }

    @MutationMapping
    public Order processPayment(@Argument ProcessPaymentInput input) {
        log.info("GraphQL Mutation: processPayment - orderId: {}", input.orderId());

        PaymentRequest paymentRequest = new PaymentRequest(
                input.amount(),
                input.cardNumber(),
                input.cvv(),
                input.cardHolderName()
        );

        return orderCommandService.processPayment(input.orderId(), paymentRequest);
    }

    @MutationMapping
    public Order cancelOrder(@Argument CancelOrderInput input) {
        log.info("GraphQL Mutation: cancelOrder - orderId: {}, reason: {}",
                input.orderId(), input.reason());

        return orderCommandService.cancelOrder(input.orderId(), input.reason());
    }
}

record CreateOrderInput(
        UUID userId,
        List<OrderItemGraphQLInput> items
) {}

record OrderItemGraphQLInput(
        Long productId,
        Integer quantity
) {}

record ProcessPaymentInput(
        Long orderId,
        BigDecimal amount,
        String cardNumber,
        String cvv,
        String cardHolderName
) {}

record CancelOrderInput(
        Long orderId,
        String reason
) {}