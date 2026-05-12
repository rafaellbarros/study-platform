package br.com.rafaellbarros.user.domain.model;

import br.com.rafaellbarros.user.domain.enums.AuthProvider;
import br.com.rafaellbarros.user.domain.enums.UserStatus;
import br.com.rafaellbarros.user.domain.valueobject.Email;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    private UUID id;
    private String externalAuthId;
    private AuthProvider authProvider;
    private String email;
    private String fullName;
    private UserStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Set<Role> roles;

}
