package br.com.rafaellbarros.user.infrastructure.persistence.repository;

import br.com.rafaellbarros.user.infrastructure.persistence.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public interface JpaRoleRepository
        extends JpaRepository<RoleEntity, UUID> {

    List<RoleEntity> findByNameIn(
            Collection<String> names
    );
}