package br.com.rafaellbarros.user.api.rest;

import br.com.rafaellbarros.user.application.dto.request.UserRequestDTO;
import br.com.rafaellbarros.user.application.dto.response.UserResponseDTO;
import br.com.rafaellbarros.user.application.usecase.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final CreateUserUseCase createUserUseCase;
    private final ListUsersUseCase listUsersUseCase;
    private final FindUserByIdUseCase findUserByIdUseCase;
    private final UpdateUserUseCase updateUserUseCase;
    private final DeleteUserUseCase deleteUserUseCase;

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> all() {
        log.info("[CONTROLLER] User all received.");
        var response = listUsersUseCase.execute();
        log.info("[CONTROLLER] User all successfully. count={}", response.size());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> find(@PathVariable UUID id) {
        log.info("[CONTROLLER] User find received. id={}", id);
        var response = findUserByIdUseCase.execute(id);
        log.info("[CONTROLLER] User find successfully. id={}", response.getId());
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> create(@Valid @RequestBody UserRequestDTO dto) {
        log.info("[CONTROLLER] Create user request received. email={}", dto.getEmail());
        var response = createUserUseCase.execute(dto);
        log.info("[CONTROLLER] User created successfully. id={}", response.getId());
        return ResponseEntity.ok(response);
    }


    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> update(@PathVariable UUID id, @Valid @RequestBody UserRequestDTO dto) {
        log.info("[CONTROLLER] Update user request received. email={}", dto.getEmail());
        dto.setId(id);
        UserResponseDTO response = updateUserUseCase.execute(dto);
        log.info("[CONTROLLER] User updated successfully. id={}", response.getId());
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        log.info("[CONTROLLER] User delete request . id={}", id);
        deleteUserUseCase.execute(id);
        log.info("[CONTROLLER] User delete successfully. id={}", id);
        return ResponseEntity.noContent().build();
    }

}