package com.wildrifttracker.interfaces.http.presentation.player;

import com.wildrifttracker.core.usecases.player.RegisterPlayerUseCase;
import com.wildrifttracker.infra.models.player.PlayerModel;
import com.wildrifttracker.interfaces.http.presentation.player.records.PlayerRequestRecord;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Interface Test: Player Controller")
public class PlayerControllerTest {
    @DisplayName("Testing method: registerPlayer - Should receive a record and return a full player object")
    @Test
    public void registerPlayer() {
        RegisterPlayerUseCase registerPlayerUseCase = Mockito.mock(RegisterPlayerUseCase.class);

        PlayerController playerController = new PlayerController(registerPlayerUseCase);
        PlayerRequestRecord playerPayload = new PlayerRequestRecord("test", "test");
        PlayerModel playerResult = new PlayerModel();

        playerResult.setPlayerId("123");
        playerResult.setNickname(playerPayload.nickname());
        playerResult.setTotalMatchs(0);
        playerResult.setRank(playerPayload.rank());
        playerResult.setVictoryCount(0);
        playerResult.setDefeatCount(0);
        playerResult.setWinRate(0);

        Mockito.when(registerPlayerUseCase.execute(playerPayload)).thenReturn(playerResult);

        ResponseEntity<PlayerModel> result = playerController.registerPlayer(playerPayload);

        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        assertEquals(playerResult.getPlayerId(), Objects.requireNonNull(result.getBody()).getPlayerId());
        assertEquals(playerResult.getNickname(), Objects.requireNonNull(result.getBody()).getNickname());
        assertEquals(playerResult.getTotalMatchs(), Objects.requireNonNull(result.getBody()).getTotalMatchs());
        assertEquals(playerResult.getRank(), Objects.requireNonNull(result.getBody()).getRank());
        assertEquals(playerResult.getVictoryCount(), Objects.requireNonNull(result.getBody()).getVictoryCount());
        assertEquals(playerResult.getDefeatCount(), Objects.requireNonNull(result.getBody()).getDefeatCount());
        assertEquals(playerResult.getWinRate(), Objects.requireNonNull(result.getBody()).getWinRate());
    }
}
