package br.com.rafaellbarros.user.infrastructure.persistence.entity;

import br.com.rafaellbarros.user.domain.enums.AuthProvider;
import br.com.rafaellbarros.user.domain.enums.UserStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users", schema = "user_schema")
public class UserEntity extends BaseEntity {


    @Id
    @Column(name = "id", length = 36, nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "external_auth_id", length = 255)
    private String externalAuthId;

    @Enumerated(EnumType.STRING)
    @Column(name = "auth_provider", length = 50, nullable = false)
    private AuthProvider authProvider;


    @Column(name = "email", length = 255, unique = true, nullable = false)
    private String email;


    @Column(name = "full_name", length = 255)
    private String fullName;


    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 50, nullable = false)
    private UserStatus status;


    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_roles",
            schema = "user_schema",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<RoleEntity> roles = new HashSet<>();


}