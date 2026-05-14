package br.com.rafaellbarros.user.infrastructure.persistence.mapper;

import br.com.rafaellbarros.user.domain.model.Role;
import br.com.rafaellbarros.user.infrastructure.persistence.entity.RoleEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RolePersistenceMapper {

    List<Role> toDomain(List<RoleEntity> entities);
}
