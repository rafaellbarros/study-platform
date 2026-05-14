package br.com.rafaellbarros.user.application.listener;

import br.com.rafaellbarros.user.domain.event.UserUpdatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserUpdatedListener {

    @ApplicationModuleListener
    public void handle(UserUpdatedEvent event) {

        log.info(
                "User updated: {}", event.userId()
        );
    }
}