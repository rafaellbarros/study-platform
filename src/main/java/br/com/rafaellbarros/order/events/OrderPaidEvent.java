package br.com.rafaellbarros.order.events;

import java.time.Instant;

public record OrderPaidEvent(
    Long orderId,
    String transactionId,
    Instant occurredAt
) {
    public OrderPaidEvent(Long orderId, String transactionId) {
        this(orderId, transactionId, Instant.now());
    }
}