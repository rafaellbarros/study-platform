package br.com.rafaellbarros.user;

import lombok.*;

import java.util.Set;
import java.util.UUID;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class UserResponseDTO {
    private UUID id;
    private String externalAuthId;
    private String authProvider;
    private String email;
    private String fullName;
    private String status;
    private Set<RoleResponseDTO> roles;
}
