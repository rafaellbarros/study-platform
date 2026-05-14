package br.com.rafaellbarros.user.application.event;

import br.com.rafaellbarros.user.domain.event.DomainEvent;

public interface DomainEventPublisher {

    void publish(DomainEvent event);
}