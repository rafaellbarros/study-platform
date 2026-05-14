package br.com.rafaellbarros.user.infrastructure.messaging;


import br.com.rafaellbarros.user.application.event.DomainEventPublisher;
import br.com.rafaellbarros.user.domain.event.DomainEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class SpringDomainEventPublisher
        implements DomainEventPublisher {

    private final ApplicationEventPublisher publisher;

    @Override
    public void publish(DomainEvent event) {
        log.info("[EVENT] Publishing domain event. type={}", event.getClass().getSimpleName());
        publisher.publishEvent(event);
    }
}