package br.com.rafaellbarros.user.application.usecase;

import br.com.rafaellbarros.user.application.dto.request.UserRequestDTO;
import br.com.rafaellbarros.user.application.dto.response.UserResponseDTO;
import br.com.rafaellbarros.user.application.mapper.UserMapper;
import br.com.rafaellbarros.user.application.service.UserApplicationService;
import br.com.rafaellbarros.user.domain.model.User;
import br.com.rafaellbarros.user.domain.police.UserPolicy;
import br.com.rafaellbarros.user.domain.service.UserDomainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class UpdateUserUseCase {

    private final UserApplicationService applicationService;

    private final UserDomainService domainService;

    private final UserPolicy policy;

    private final UserMapper mapper;


    public UserResponseDTO execute(UserRequestDTO dto) {
        log.info("[USECASE] Starting update user flow. email={}", dto.getEmail());

        User domain = applicationService.findById(dto.getId());


        log.debug(
                "[USECASE] DTO mapped to domain. email={}",
                domain.getEmail()
        );

        policy.validateCreate(domain);

        mapper.fromDTO(dto , domain);
        var saved = applicationService.update(domain);

        log.info(
                "[USECASE] User persisted successfully. id={}",
                saved.getId()
        );

        return mapper.toDTO(saved);
    }
}
