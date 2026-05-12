package br.com.rafaellbarros.user.infrastructure.persistence.mapper;

import br.com.rafaellbarros.user.domain.model.User;
import br.com.rafaellbarros.user.infrastructure.persistence.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserPersistenceMapper {

    User toDomain(UserEntity entity);

    UserEntity toEntity(User domain);
}