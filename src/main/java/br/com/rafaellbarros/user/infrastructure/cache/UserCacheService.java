package br.com.rafaellbarros.user.infrastructure.cache;

import br.com.rafaellbarros.user.domain.model.User;
import br.com.rafaellbarros.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserCacheService {

    private final UserRepository repository;

    @Cacheable(value = "users", key = "#id")
    public Optional<User> findById(UUID id) {
        log.info("[CACHE] Cache miss. Loading user from database. id={}", id);
        return repository.findById(id);
    }
}
