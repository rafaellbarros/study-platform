package br.com.rafaellbarros.order.events;

import java.time.Instant;
import java.util.UUID;

public record OrderCreatedEvent(
    Long orderId,
    UUID userId,
    Instant occurredAt
) {
    public OrderCreatedEvent(Long orderId, UUID userId) {
        this(orderId, userId, Instant.now());
    }
}