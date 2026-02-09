package com.wildrifttracker.core.usecases.user;

import com.wildrifttracker.domain.dtos.user.CreateUserPayloadDto;
import com.wildrifttracker.infra.database.models.User;
import com.wildrifttracker.infra.database.repositories.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Core :: Usecases :: User :: RegisterUserUseCaseTest")
public class RegisterUserUseCaseTest {
    @DisplayName("Testing method: create")
    @Test
    public void createTest() {
        String name = "lordcroft";
        String email = "test@email";
        String password = "123A";

        UserRepository userRepository = Mockito.mock(UserRepository.class);

        CreateUserPayloadDto payloadTest = new CreateUserPayloadDto(name, email, password);
        RegisterUserUseCase useCaseTest = new RegisterUserUseCase(userRepository);

        User userResult = new User();
        userResult.setName(name);

        Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(userResult);

        User useCaseResult = useCaseTest.create(payloadTest);

        assertEquals(name, useCaseResult.getName());
    }
}
