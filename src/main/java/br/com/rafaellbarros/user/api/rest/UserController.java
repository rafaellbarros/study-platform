package br.com.rafaellbarros.user.api.rest;

import br.com.rafaellbarros.user.application.dto.request.UserRequestDTO;
import br.com.rafaellbarros.user.application.service.UserApplicationService;
import br.com.rafaellbarros.user.domain.model.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserApplicationService userApplicationService;

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(userApplicationService.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable UUID id) {
        var responseDTO = userApplicationService.findById(id);
        return ResponseEntity.ok(responseDTO);
    }

    @PostMapping
    public ResponseEntity<User> save(@Valid @RequestBody User dto) {
        var responseDTO = userApplicationService.save(dto);
        return ResponseEntity.ok(responseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable UUID id, @Valid @RequestBody UserRequestDTO dto) {
        dto.setId(id);
        return ResponseEntity.ok(userApplicationService.update(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID id) {
        userApplicationService.delete(id);
        return ResponseEntity.noContent().build();
    }

}