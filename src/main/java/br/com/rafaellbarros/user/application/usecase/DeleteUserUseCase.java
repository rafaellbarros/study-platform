package br.com.rafaellbarros.user.application.usecase;

import br.com.rafaellbarros.user.application.service.UserApplicationService;
import br.com.rafaellbarros.user.domain.police.UserPolicy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class DeleteUserUseCase {

    private final UserApplicationService applicationService;

    private final UserPolicy policy;

    public void execute(UUID id) {

        log.info("[USECASE] Starting delete user flow. id={}", id);

        var user = applicationService.findById(id);

        policy.validateDeletion(user);

        applicationService.delete(user);

        log.info("[USECASE] User delete successfully. id={}", id);
    }
}
