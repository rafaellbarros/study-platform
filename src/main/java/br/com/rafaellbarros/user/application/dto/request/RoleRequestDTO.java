package br.com.rafaellbarros.user.application.dto.request;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class RoleRequestDTO {
    private UUID id;
    private String name;
}
