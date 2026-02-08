package com.wildrifttracker.core.usecases.user;

import com.wildrifttracker.domain.dtos.user.CreateUserPayloadDto;
import com.wildrifttracker.domain.enums.ErrorMessages;
import com.wildrifttracker.infra.database.models.Player;
import com.wildrifttracker.infra.database.models.User;
import com.wildrifttracker.infra.database.repositories.UserRepository;
import com.wildrifttracker.infra.exceptions.NotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class RegisterUserUseCase {
    private final UserRepository userRepository;

    @Autowired
    public RegisterUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll() {
        return this.userRepository.findAll();
    }

    public User getById(Long userId) {
        return this.userRepository
                .findById(userId)
                .orElseThrow(
                        () -> new NotFoundException(ErrorMessages.PLAYER_NOT_FOUND.getMessage())
                );
    }

    public User create(@Valid CreateUserPayloadDto payload) {
        User userToCreate = new User();

        userToCreate.setEmail(payload.email());
        userToCreate.setName(payload.name());
        userToCreate.setPassword(payload.password());

        return this.userRepository.save(userToCreate);
    }
}
