package br.com.rafaellbarros.user.domain.event;

import java.time.LocalDateTime;
import java.util.UUID;

public record UserUpdatedEvent(
        UUID userId,
        LocalDateTime occurredOn
) implements DomainEvent {
}