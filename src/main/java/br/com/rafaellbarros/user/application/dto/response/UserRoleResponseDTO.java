package br.com.rafaellbarros.user.application.dto.response;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class UserRoleResponseDTO {

    private String id;
    private String name;
}
