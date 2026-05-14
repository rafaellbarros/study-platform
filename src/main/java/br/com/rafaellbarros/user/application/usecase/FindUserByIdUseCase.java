package br.com.rafaellbarros.user.application.usecase;

import br.com.rafaellbarros.user.application.dto.response.UserResponseDTO;
import br.com.rafaellbarros.user.application.exception.NotFoundException;
import br.com.rafaellbarros.user.application.mapper.UserMapper;
import br.com.rafaellbarros.user.application.service.UserApplicationService;
import br.com.rafaellbarros.user.domain.model.User;
import br.com.rafaellbarros.user.infrastructure.cache.UserCacheService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class FindUserByIdUseCase {

    private final UserCacheService cacheService;

    private final UserMapper mapper;

    public UserResponseDTO execute(UUID id) {
        log.info("[USECASE] Starting find user flow. id={}", id);
        User user = cacheService.findById(id)
                .orElseThrow(() ->
                        new NotFoundException(
                                "User not found"
                        )
                );
        log.info("[USECASE] User find successfully. id={}", id);
        return mapper.toDTO(user);
    }
}
