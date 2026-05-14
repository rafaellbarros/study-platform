package br.com.rafaellbarros.user.application.usecase;

import br.com.rafaellbarros.user.application.dto.response.UserResponseDTO;
import br.com.rafaellbarros.user.application.mapper.UserMapper;
import br.com.rafaellbarros.user.application.service.UserApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class ListUsersUseCase {

    private final UserApplicationService applicationService;
    private final UserMapper mapper;

    public List<UserResponseDTO> execute() {
        log.info("[USECASE] Starting user list flow.");
        var users = applicationService.findAll();
        log.info("[USECASE] Finishing user list flow. count: {}", users.size());
        return mapper.toDTO(users);
    }
}
