package br.com.rafaellbarros.user.domain.event;

import java.time.LocalDateTime;

public interface DomainEvent {

    LocalDateTime occurredOn();
}