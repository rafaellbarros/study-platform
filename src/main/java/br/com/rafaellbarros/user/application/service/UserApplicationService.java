package br.com.rafaellbarros.user.application.service;


import br.com.rafaellbarros.user.application.dto.request.UserRequestDTO;
import br.com.rafaellbarros.user.application.exception.BusinessException;
import br.com.rafaellbarros.user.domain.model.User;
import br.com.rafaellbarros.user.infrastructure.persistence.adapter.UserPersistenceAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS)
public class UserApplicationService {

    private final UserPersistenceAdapter persistenceAdapter;


    public List<User> list() {
        List<User> users = persistenceAdapter.findAll();
        return users;
        // return mapper.toDTO(users);
    }

    public User findById(UUID id) {
        // return mapper.toDTO(findEntityById(id));
        return findEntityById(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public User save(User dto) {
        // return mapper.toDTO(repository.save(mapper.toEntity(dto)));
        User save = persistenceAdapter.save(dto);
        return save;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public User update(UserRequestDTO dto) {
        /*
        UserEntity entity = findEntityById(dto.getId());
        mapper.fromDTO(dto, entity);
        UserEntity saved = repository.save(entity);
        return mapper.toDTO(saved);

         */
        User user = findEntityById(dto.getId());

        BeanUtils.copyProperties(dto, user);

        return persistenceAdapter.save(user);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(UUID id) {
        User user = findEntityById(id);
        persistenceAdapter.delete(user);
    }

    public User findEntityById(UUID id) {
        return persistenceAdapter.findById(id)
                .orElseThrow(() -> new BusinessException("User not found: " + id));
    }

}