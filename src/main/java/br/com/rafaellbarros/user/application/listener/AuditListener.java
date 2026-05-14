package br.com.rafaellbarros.user.application.listener;

import br.com.rafaellbarros.user.domain.event.UserCreatedEvent;
import br.com.rafaellbarros.user.domain.event.UserDeletedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class AuditListener {

    @ApplicationModuleListener
    public void onUserCreated(UserCreatedEvent event) {
        log.info("[AUDIT] User created: {}", event.userId());
    }

    @ApplicationModuleListener
    public void onUserDeleted(UserDeletedEvent event) {
        log.info("[AUDIT] User deleted: {}", event.userId());
    }
}