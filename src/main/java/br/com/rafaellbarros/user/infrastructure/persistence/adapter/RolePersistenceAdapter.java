package br.com.rafaellbarros.user.infrastructure.persistence.adapter;

import br.com.rafaellbarros.user.domain.model.Role;
import br.com.rafaellbarros.user.domain.repository.RoleRepository;
import br.com.rafaellbarros.user.infrastructure.persistence.entity.RoleEntity;
import br.com.rafaellbarros.user.infrastructure.persistence.mapper.RolePersistenceMapper;
import br.com.rafaellbarros.user.infrastructure.persistence.repository.JpaRoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class RolePersistenceAdapter implements RoleRepository {

    private final JpaRoleRepository jpaRoleRepository;

    private final RolePersistenceMapper rolePersistenceMapper;

    @Override
    public Set<Role> findByNames(Set<String> names) {
        List<RoleEntity> entities = jpaRoleRepository.findByNameIn(names);
        List<Role> roles = rolePersistenceMapper.toDomain(entities);
        return new HashSet<>(roles);
    }
}
