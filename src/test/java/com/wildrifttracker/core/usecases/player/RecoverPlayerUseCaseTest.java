package com.wildrifttracker.core.usecases.player;

import com.wildrifttracker.infra.database.models.Player;
import com.wildrifttracker.infra.database.repositories.PlayerRepository;
import com.wildrifttracker.infra.exceptions.NotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Core :: Usecases :: Player :: RecoverPlayerUseCaseTest")
public class RecoverPlayerUseCaseTest {
    @DisplayName("Testing method: getAll")
    @Test
    public void getAllTest() {
        PlayerRepository playerRepository = Mockito.mock(PlayerRepository.class);

        RecoverPlayerUseCase useCaseTest = new RecoverPlayerUseCase(playerRepository);

        List<Player> playerResult = new ArrayList<>();

        playerResult.add(new Player());
        playerResult.add(new Player());

        Mockito.when(playerRepository.findAll()).thenReturn(playerResult);

        List<Player> useCaseResult = useCaseTest.getAll();

        assertEquals(2, useCaseResult.size());
        assertEquals(playerResult.size(), useCaseResult.size());
    }

    @DisplayName("Testing method: getById")
    @Test
    public void getByIdTest() {
        PlayerRepository playerRepository = Mockito.mock(PlayerRepository.class);

        RecoverPlayerUseCase useCaseTest = new RecoverPlayerUseCase(playerRepository);

        Player playerResult = new Player();

        playerResult.setNickname("test");

        Mockito.when(playerRepository.findById(123L)).thenReturn(Optional.of(playerResult));

        Player useCaseResult = useCaseTest.getById(123L);

        assertEquals(playerResult.getNickname(), useCaseResult.getNickname());
    }

    @DisplayName("Testing method: getById - Not Found")
    @Test
    public void getByIdNotFoundExceptionTest() {
        PlayerRepository playerRepository = Mockito.mock(PlayerRepository.class);

        RecoverPlayerUseCase useCaseTest = new RecoverPlayerUseCase(playerRepository);

        Mockito.when(playerRepository.findById(123L)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> useCaseTest.getById(123L));
    }
}
