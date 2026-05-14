package br.com.rafaellbarros.user.domain.police;

import br.com.rafaellbarros.user.application.exception.BusinessException;
import br.com.rafaellbarros.user.domain.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserPolicy {

    public void validateCreate(User user) {


        log.debug(
                "[POLICY] Validating user creation policy. email={}",
                user.getEmail()
        );

        if(user.getEmail() != null && user.getEmail().endsWith("@blocked.com")) {

            log.warn(
                    "[POLICY] Blocked email domain detected. email={}",
                    user.getEmail()
            );

            throw new BusinessException(
                    "Invalid domain"
            );
        }
    }

    public void validateDeletion(
            User currentUser
    ) {
        log.debug(
                "[POLICY] Validating user deletion policy. email={}",
                currentUser.getEmail()
        );

        if(!currentUser.isAdmin()) {

            log.warn(
                    "[POLICY] Blocked only admins can delete users"
            );

            throw new BusinessException(
                    "Only admins can delete users"
            );
        }
    }
}