package br.com.rafaellbarros.user.application.mapper;

import br.com.rafaellbarros.shared.mapper.BaseMapper;
import br.com.rafaellbarros.user.application.dto.request.UserRequestDTO;
import br.com.rafaellbarros.user.application.dto.response.UserResponseDTO;
import br.com.rafaellbarros.user.domain.model.User;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper extends BaseMapper<User, UserResponseDTO> {

    @Override
    UserResponseDTO toDTO(User model);

    @Override
    User toDomain(UserResponseDTO dto);

    @Override
    List<UserResponseDTO> toDTO(List<User> models);

    @Override
    List<User> toDomain(List<UserResponseDTO> dtos);

    @Mapping(target = "roles", ignore = true)
    User toDomain(UserRequestDTO dto);

    @Mapping(target = "roles", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void fromDTO(UserRequestDTO dto, @MappingTarget User model);

}