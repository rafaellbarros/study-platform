package br.com.rafaellbarros.user.domain.service;

import br.com.rafaellbarros.user.application.exception.BusinessException;
import br.com.rafaellbarros.user.domain.enums.UserStatus;
import br.com.rafaellbarros.user.domain.model.User;
import br.com.rafaellbarros.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserDomainService {

    private final UserRepository repository;

    public void validateNewUser(User user) {


        log.debug(
                "[DOMAIN] Validating new user. email={}",
                user.getEmail()
        );

        boolean exists =
                repository.existsByEmail(user.getEmail());

        if (exists) {

            log.warn(
                    "[DOMAIN] Email already exists. email={}",
                    user.getEmail()
            );

            throw new BusinessException(
                    "Email already exists"
            );
        }
    }

    public void activate(User user) {

        log.debug(
                "[DOMAIN] Validating role user. email={}",
                user.getEmail()
        );

        if(user.getRoles() == null || user.getRoles().isEmpty()) {
            log.warn(
                    "[DOMAIN] Role user must have roles."
            );

            throw new BusinessException(
                    "User must have roles"
            );
        }

        user.setStatus(UserStatus.ACTIVE);
    }
}
