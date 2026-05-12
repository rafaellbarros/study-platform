package br.com.rafaellbarros.order.infrastructure;

import br.com.rafaellbarros.order.application.dto.OrderItemInput;
import br.com.rafaellbarros.order.domain.Order;
import br.com.rafaellbarros.order.domain.OrderStatus;
import br.com.rafaellbarros.order.domain.exception.OrderBusinessException;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.util.List;

@Component
public class OrderValidator {

    public void validateOrderItems(List<OrderItemInput> items) {
        if (items == null || items.isEmpty()) {
            throw new OrderBusinessException("Order must contain at least one item", "EMPTY_ORDER");
        }

        for (OrderItemInput item : items) {
            if (item.getProductId() == null) {
                throw new OrderBusinessException("Product ID is required", "INVALID_PRODUCT");
            }
            if (item.getQuantity() == null || item.getQuantity() <= 0) {
                throw new OrderBusinessException("Quantity must be greater than zero", "INVALID_QUANTITY");
            }
            if (item.getQuantity() > 999) {
                throw new OrderBusinessException("Maximum quantity per item is 999", "QUANTITY_EXCEEDED");
            }
        }
    }

    public void validatePaymentEligibility(Order order) {
        if (order.getStatus() != OrderStatus.PENDING) {
            throw new OrderBusinessException(
                    String.format("Cannot process payment for order with status: %s", order.getStatus()),
                    "INVALID_STATUS"
            );
        }

        if (order.getTotal().compareTo(BigDecimal.ZERO) <= 0) {
            throw new OrderBusinessException(
                    "Cannot process payment for order with zero total",
                    "INVALID_AMOUNT"
            );
        }
    }

    public void validateCancellation(Order order) {
        if (order.getStatus() == OrderStatus.DELIVERED) {
            throw new OrderBusinessException("Cannot cancel delivered order", "DELIVERED_ORDER");
        }

        if (order.getStatus() == OrderStatus.CANCELLED) {
            throw new OrderBusinessException("Order is already cancelled", "ALREADY_CANCELLED");
        }
    }
}