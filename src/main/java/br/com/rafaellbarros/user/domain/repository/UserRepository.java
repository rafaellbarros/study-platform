package br.com.rafaellbarros.user.domain.repository;

import br.com.rafaellbarros.user.domain.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository {

    Optional<User> findById(UUID id);

    List<User> findAll();

    User save(User user);

    void delete(User user);
}