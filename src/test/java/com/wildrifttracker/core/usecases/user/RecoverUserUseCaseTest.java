package com.wildrifttracker.core.usecases.user;

import com.wildrifttracker.infra.database.models.User;
import com.wildrifttracker.infra.database.repositories.UserRepository;
import com.wildrifttracker.infra.exceptions.NotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Core :: Usecases :: User :: RecoverUserUseCaseTest")
public class RecoverUserUseCaseTest {
    @DisplayName("Testing method: getAll")
    @Test
    public void getAllTest() {
        UserRepository userRepository = Mockito.mock(UserRepository.class);

        RecoverUserUseCase useCaseTest = new RecoverUserUseCase(userRepository);

        List<User> userResult = new ArrayList<>();

        userResult.add(new User());
        userResult.add(new User());

        Mockito.when(userRepository.findAll()).thenReturn(userResult);

        List<User> useCaseResult = useCaseTest.getAll();

        assertEquals(2, useCaseResult.size());
        assertEquals(userResult.size(), useCaseResult.size());
    }

    @DisplayName("Testing method: getById")
    @Test
    public void getByIdTest() {
        UserRepository userRepository = Mockito.mock(UserRepository.class);

        RecoverUserUseCase useCaseTest = new RecoverUserUseCase(userRepository);

        User userResult = new User();

        userResult.setName("test");

        Mockito.when(userRepository.findById(123L)).thenReturn(Optional.of(userResult));

        User useCaseResult = useCaseTest.getById(123L);

        assertEquals(userResult.getName(), useCaseResult.getName());
    }

    @DisplayName("Testing method: getById - Not Found")
    @Test
    public void getByIdNotFoundExceptionTest() {
        UserRepository userRepository = Mockito.mock(UserRepository.class);

        RecoverUserUseCase useCaseTest = new RecoverUserUseCase(userRepository);

        Mockito.when(userRepository.findById(123L)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> useCaseTest.getById(123L));
    }
}
