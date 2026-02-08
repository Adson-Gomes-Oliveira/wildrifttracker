package com.wildrifttracker.interfaces.http.presentation.controllers;

import com.wildrifttracker.core.usecases.user.RegisterUserUseCase;
import com.wildrifttracker.domain.dtos.player.ReturnPlayerDto;
import com.wildrifttracker.domain.dtos.user.CreateUserPayloadDto;
import com.wildrifttracker.domain.dtos.user.ReturnUserDto;
import com.wildrifttracker.domain.utils.DataPreparer;
import com.wildrifttracker.infra.database.models.Player;
import com.wildrifttracker.infra.database.models.User;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tracker/user")
@Tag(name = "User")
public class UserController {
    private final RegisterUserUseCase registerUserUseCase;

    @Autowired
    public UserController(RegisterUserUseCase registerUserUseCase) {
        this.registerUserUseCase = registerUserUseCase;
    }

    @GetMapping
    public ResponseEntity<List<ReturnUserDto>> getAllUsers() {
        List<User> result = this.registerUserUseCase.getAll();

        List<ReturnUserDto> resultSanitized = DataPreparer
                .sanitizeListData(ReturnUserDto::new, result);

        return ResponseEntity.status(HttpStatus.OK).body(resultSanitized);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<ReturnUserDto> getUserById(@PathVariable Long userId) {
        User result = this.registerUserUseCase.getById(userId);

        ReturnUserDto resultSanitized = DataPreparer
                .sanitizeUniqueData(ReturnUserDto::new, result);

        return ResponseEntity.status(HttpStatus.OK).body(resultSanitized);
    }

    @PostMapping("/register")
    public ResponseEntity<ReturnUserDto> registerUser(
            @RequestBody CreateUserPayloadDto payload
    ) {
        User result = this.registerUserUseCase.create(payload);

        ReturnUserDto resultSanitized = DataPreparer
                .sanitizeUniqueData(ReturnUserDto::new, result);

        return ResponseEntity.status(HttpStatus.CREATED).body(resultSanitized);
    }
}
