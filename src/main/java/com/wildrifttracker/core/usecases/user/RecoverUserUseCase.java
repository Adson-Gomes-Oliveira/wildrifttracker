package com.wildrifttracker.core.usecases.user;

import com.wildrifttracker.domain.enums.ErrorMessages;
import com.wildrifttracker.infra.database.models.User;
import com.wildrifttracker.infra.database.repositories.UserRepository;
import com.wildrifttracker.infra.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class RecoverUserUseCase {
    private final UserRepository userRepository;

    @Autowired
    public RecoverUserUseCase(UserRepository userRepository) {
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
}
