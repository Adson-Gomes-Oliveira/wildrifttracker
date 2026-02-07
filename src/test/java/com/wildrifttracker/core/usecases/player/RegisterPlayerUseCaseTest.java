package com.wildrifttracker.core.usecases.player;

import com.wildrifttracker.infra.database.models.Player;
import com.wildrifttracker.domain.dtos.player.CreatePlayerPayloadDto;
import com.wildrifttracker.infra.database.repositories.PlayerRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Use Case Test: Register Player")
public class RegisterPlayerUseCaseTest {
    @DisplayName("Testing method: Execute - Should create correct data")
    @Test
    public void executeTest() {
        String nick = "lordcroft";
        PlayerRepository playerRepository = Mockito.mock(PlayerRepository.class);

        CreatePlayerPayloadDto payloadTest = new CreatePlayerPayloadDto(nick);
        RegisterPlayerUseCase useCaseTest = new RegisterPlayerUseCase(playerRepository);

        Player playerResult = new Player();
        playerResult.setNickname(nick);

        Mockito.when(playerRepository.save(playerResult)).thenReturn(playerResult);

        Player useCaseResult = useCaseTest.create(payloadTest);

        assertEquals(nick, useCaseResult.getNickname());
    }
}
