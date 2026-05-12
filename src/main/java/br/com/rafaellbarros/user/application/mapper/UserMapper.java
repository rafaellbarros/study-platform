package br.com.rafaellbarros.user.application.mapper;

import br.com.rafaellbarros.shared.mapper.BaseMapper;
import br.com.rafaellbarros.user.infrastructure.persistence.entity.UserEntity;
import br.com.rafaellbarros.user.application.dto.request.UserRequestDTO;
import br.com.rafaellbarros.user.application.dto.response.UserResponseDTO;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper extends BaseMapper<UserEntity, UserResponseDTO> {

    @Override
    UserResponseDTO toDTO(UserEntity entity);

    @Override
    UserEntity toEntity(UserResponseDTO dto);

    @Override
    List<UserResponseDTO> toDTO(List<UserEntity> entities);

    @Override
    List<UserEntity> toEntity(List<UserResponseDTO> dtos);

    @Override
    @InheritInverseConfiguration(name = "toDTO")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void fromDTO(UserResponseDTO dto, @MappingTarget UserEntity entity);

    UserEntity toEntity(UserRequestDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void fromDTO(UserRequestDTO dto, @MappingTarget UserEntity entity);


}