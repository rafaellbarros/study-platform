package br.com.rafaellbarros.user;

import br.com.rafaellbarros.shared.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS)
public class UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    public List<UserResponseDTO> list() {
        List<User> users = repository.findAll();
        return mapper.toDTO(users);
    }

    public UserResponseDTO findById(UUID id) {
        return mapper.toDTO(findEntityById(id));
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public UserResponseDTO save(UserRequestDTO dto) {
        return mapper.toDTO(repository.save(mapper.toEntity(dto)));
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public UserResponseDTO update(UserRequestDTO dto) {
        User entity = findEntityById(dto.getId());
        mapper.fromDTO(dto, entity);
        User saved = repository.save(entity);
        return mapper.toDTO(saved);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(UUID id) {
        repository.delete(findEntityById(id));
    }

    public User findEntityById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new BusinessException("User not found: " + id));
    }

}