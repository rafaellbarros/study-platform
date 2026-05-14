package br.com.rafaellbarros.user.domain.repository;

import br.com.rafaellbarros.user.domain.model.Role;

import java.util.Set;

public interface RoleRepository {

    Set<Role> findByNames(Set<String> names);
}