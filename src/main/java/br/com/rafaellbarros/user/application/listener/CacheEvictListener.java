package br.com.rafaellbarros.user.application.listener;

import br.com.rafaellbarros.user.domain.event.UserDeletedEvent;
import br.com.rafaellbarros.user.domain.event.UserUpdatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CacheEvictListener {

    @ApplicationModuleListener
    @CacheEvict(
            value = "users",
            key = "#event.userId"
    )
    public void onUserUpdated(
            UserUpdatedEvent event
    ) {

        log.info(
                "Cache evicted for user: {}"
                        , event.userId()
        );
    }

    @ApplicationModuleListener
    @CacheEvict(
            value = "users",
            key = "#event.userId"
    )
    public void onUserDeleted(
            UserDeletedEvent event
    ) {

        log.info(
                "Cache removed for user: {}"
                , event.userId()
        );
    }
}