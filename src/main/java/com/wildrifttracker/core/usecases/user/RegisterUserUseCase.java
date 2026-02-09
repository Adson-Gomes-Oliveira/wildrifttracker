package com.wildrifttracker.core.usecases.user;

import com.wildrifttracker.domain.dtos.user.CreateUserPayloadDto;
import com.wildrifttracker.infra.database.models.User;
import com.wildrifttracker.infra.database.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class RegisterUserUseCase {
    private final UserRepository userRepository;

    @Autowired
    public RegisterUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(@Valid CreateUserPayloadDto payload) {
        User userToCreate = new User();

        userToCreate.setEmail(payload.email());
        userToCreate.setName(payload.name());
        userToCreate.setPassword(payload.password());

        return this.userRepository.save(userToCreate);
    }
}
