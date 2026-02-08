package com.wildrifttracker.interfaces.http.presentation.controllers;

import com.wildrifttracker.core.usecases.user.RegisterUserUseCase;
import com.wildrifttracker.domain.dtos.user.CreateUserPayloadDto;
import com.wildrifttracker.domain.dtos.user.ReturnUserDto;
import com.wildrifttracker.infra.database.models.User;
import com.wildrifttracker.infra.database.models.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Interfaces :: Http :: Presentation :: Controllers :: UserController")
public class UserControllerTest {
    @DisplayName("Testing method: registerUser - Should receive a record and return a full player object")
    @Test
    public void registerUser() {
        String name = "lordcroft";
        String email = "test@email";
        String password = "123A";

        RegisterUserUseCase registerUserUseCase = Mockito.mock(RegisterUserUseCase.class);

        UserController userController = new UserController(registerUserUseCase);
        CreateUserPayloadDto userPayload = new CreateUserPayloadDto(name, email, password);
        User userResult = new User();

        userResult.setName(userPayload.name());

        Mockito.when(registerUserUseCase.create(userPayload)).thenReturn(userResult);

        ResponseEntity<ReturnUserDto> result = userController.registerUser(userPayload);

        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        assertEquals(userResult.getName(), Objects.requireNonNull(result.getBody()).name());
    }

    @DisplayName("Testing method: getAllUsers")
    @Test
    public void getAllUsers() {
        RegisterUserUseCase registerUserUseCase = Mockito.mock(RegisterUserUseCase.class);

        UserController userController = new UserController(registerUserUseCase);
        List<User> userResult = new ArrayList<>();

        userResult.add(new User());
        userResult.add(new User());

        Mockito.when(registerUserUseCase.getAll()).thenReturn(userResult);

        ResponseEntity<List<ReturnUserDto>> result = userController.getAllUsers();

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(userResult.size(), Objects.requireNonNull(result.getBody()).size());
    }

    @DisplayName("Testing method: getUserById")
    @Test
    public void getUserById() {
        RegisterUserUseCase registerUserUseCase = Mockito.mock(RegisterUserUseCase.class);

        UserController userController = new UserController(registerUserUseCase);
        User userResult = new User();

        userResult.setName("teste");

        Mockito.when(registerUserUseCase.getById(123L)).thenReturn(userResult);

        ResponseEntity<ReturnUserDto> result = userController.getUserById(123L);

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(userResult.getName(), Objects.requireNonNull(result.getBody()).name());
    }
}
