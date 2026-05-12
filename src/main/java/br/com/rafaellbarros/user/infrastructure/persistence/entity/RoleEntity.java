package br.com.rafaellbarros.user.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles", schema = "user_schema")
public class RoleEntity {

    @Id
    @Column(name = "id", length = 36, nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", length = 100, unique = true, nullable = false)
    private String name;


}