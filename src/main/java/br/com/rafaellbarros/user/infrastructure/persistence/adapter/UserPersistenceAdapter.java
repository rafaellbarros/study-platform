package br.com.rafaellbarros.user.infrastructure.persistence.adapter;

import br.com.rafaellbarros.user.domain.model.User;
import br.com.rafaellbarros.user.domain.repository.UserRepository;
import br.com.rafaellbarros.user.infrastructure.persistence.entity.UserEntity;
import br.com.rafaellbarros.user.infrastructure.persistence.mapper.UserPersistenceMapper;
import br.com.rafaellbarros.user.infrastructure.persistence.repository.JpaUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserRepository {

    private final JpaUserRepository repository;

    private final UserPersistenceMapper mapper;

    @Override
    public Optional<User> findById(UUID id) {

        log.debug("[PERSISTENCE] User find in database. id={}", id);


        return repository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public List<User> findAll() {

        return repository.findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public User save(User user) {

        UserEntity entity = mapper.toEntity(user);

        UserEntity saved = repository.save(entity);

        return mapper.toDomain(saved);
    }

    @Override
    public void delete(User user) {
        repository.delete(mapper.toEntity(user));
    }

    @Override
    public boolean existsByEmail(String email) {
        return repository.existsByEmail(email);
    }
}