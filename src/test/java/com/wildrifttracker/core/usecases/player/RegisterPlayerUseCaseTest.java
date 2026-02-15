package com.wildrifttracker.core.usecases.player;

import com.wildrifttracker.infra.database.models.Player;
import com.wildrifttracker.domain.dtos.player.CreatePlayerPayloadDto;
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

@DisplayName("Core :: Usecases :: Player :: RegisterPlayerUseCaseTest")
public class RegisterPlayerUseCaseTest {
    @DisplayName("Testing method: create")
    @Test
    public void createTest() {
        String nick = "lordcroft";
        PlayerRepository playerRepository = Mockito.mock(PlayerRepository.class);

        CreatePlayerPayloadDto payloadTest = new CreatePlayerPayloadDto(nick);
        RegisterPlayerUseCase useCaseTest = new RegisterPlayerUseCase(playerRepository);

        Player playerResult = new Player();
        playerResult.setNickname(nick);

        Mockito.when(playerRepository.save(Mockito.any(Player.class))).thenReturn(playerResult);

        Player useCaseResult = useCaseTest.create(payloadTest);

        assertEquals(nick, useCaseResult.getNickname());
    }
}
