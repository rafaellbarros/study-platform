package br.com.rafaellbarros.user;

import br.com.rafaellbarros.shared.mapper.BaseMapper;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper extends BaseMapper<User, UserResponseDTO> {

    @Override
    UserResponseDTO toDTO(User entity);

    @Override
    User toEntity(UserResponseDTO dto);

    @Override
    List<UserResponseDTO> toDTO(List<User> entities);

    @Override
    List<User> toEntity(List<UserResponseDTO> dtos);

    @Override
    @InheritInverseConfiguration(name = "toDTO")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void fromDTO(UserResponseDTO dto, @MappingTarget User entity);

    User toEntity(UserRequestDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void fromDTO(UserRequestDTO dto, @MappingTarget User entity);


}