package br.com.rafaellbarros.user.application.dto.request;

import br.com.rafaellbarros.user.domain.enums.AuthProvider;
import br.com.rafaellbarros.user.domain.enums.UserStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserRequestDTO {
    private UUID id;
    private String externalAuthId;
    private AuthProvider authProvider;
    private String email;
    private String fullName;
    private UserStatus status;
}
