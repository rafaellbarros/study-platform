package br.com.rafaellbarros.user.application.service;


import br.com.rafaellbarros.user.application.event.DomainEventPublisher;
import br.com.rafaellbarros.user.application.exception.NotFoundException;
import br.com.rafaellbarros.user.domain.event.UserCreatedEvent;
import br.com.rafaellbarros.user.domain.event.UserDeletedEvent;
import br.com.rafaellbarros.user.domain.event.UserUpdatedEvent;
import br.com.rafaellbarros.user.domain.model.User;
import br.com.rafaellbarros.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS)
public class UserApplicationService {

    private final UserRepository repository;

    private final DomainEventPublisher publisher;
    private final ApplicationEventPublisher events;

    @Transactional
    public User create(User user) {

        log.info("[APPLICATION] Persisting user create. user={}", user);


        User saved = repository.save(user);

        log.info("[APPLICATION] User persisted create successfully. id={}", saved.getId());

        publisher.publish(
                new UserCreatedEvent(
                        saved.getId(),
                        saved.getEmail(),
                        LocalDateTime.now()
                )
        );


        log.info("[APPLICATION] UserCreatedEvent published. id={}", saved.getId());

        return saved;
    }

    @Transactional
    public User update(User user) {

        log.info("[APPLICATION] Persisting user update. user={}", user);

        // User userId = findUserById(user.getId());
        User updated = repository.save(user);

        log.info("[APPLICATION] User persisted update successfully. id={}", updated.getId());

        publisher.publish(
                new UserUpdatedEvent(
                        updated.getId(),
                        LocalDateTime.now()
                )
        );

        log.info("[APPLICATION] UserUpdatedEvent published. id={}", updated.getId());

        return updated;
    }

    public User findById(UUID id) {
        log.info("[APPLICATION] Persisting user find. id={}", id);
        return findUserById(id);
    }

    public List<User> findAll() {
        log.info("[APPLICATION] Persisting user findAll.");
        return repository.findAll();
    }

    @Transactional
    public void delete(User user) {

        log.info("[APPLICATION] Persisting user delete. user={}", user);

        repository.delete(user);

        log.info("[APPLICATION] User persisted delete successfully. id={}", user.getId());

        publisher.publish(
                new UserDeletedEvent(
                        user.getId(),
                        LocalDateTime.now()
                )
        );

        log.info("[APPLICATION] UserDeletedEvent published. id={}", user.getId());
    }

    private User findUserById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("User not found: " + id));
    }
}