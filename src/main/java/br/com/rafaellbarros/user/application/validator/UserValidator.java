package br.com.rafaellbarros.user.application.validator;

import br.com.rafaellbarros.user.application.dto.request.UserRequestDTO;
import br.com.rafaellbarros.user.application.exception.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class UserValidator {

    public void validateCreate(UserRequestDTO dto) {

        if(dto.getEmail() == null) {
            throw new ValidationException("Email is required");
        }
    }
}