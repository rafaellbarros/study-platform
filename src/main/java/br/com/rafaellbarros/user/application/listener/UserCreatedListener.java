package br.com.rafaellbarros.user.application.listener;

import br.com.rafaellbarros.user.domain.event.UserCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserCreatedListener {

    @ApplicationModuleListener
    public void handle(UserCreatedEvent event) {

        log.info(
                "User created: {}", event.email()
        );
    }
}