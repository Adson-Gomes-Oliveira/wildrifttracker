package com.wildrifttracker.interfaces.http.presentation.controllers;

import com.wildrifttracker.core.usecases.user.RegisterUserUseCase;
import com.wildrifttracker.domain.dtos.user.CreateUserPayloadDto;
import com.wildrifttracker.domain.dtos.user.ReturnUserDto;
import com.wildrifttracker.domain.utils.DataPreparer;
import com.wildrifttracker.infra.database.models.User;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tracker/user")
@Tag(name = "User")
public class UserController {
    private final RegisterUserUseCase registerUserUseCase;

    @Autowired
    public UserController(RegisterUserUseCase registerUserUseCase) {
        this.registerUserUseCase = registerUserUseCase;
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
