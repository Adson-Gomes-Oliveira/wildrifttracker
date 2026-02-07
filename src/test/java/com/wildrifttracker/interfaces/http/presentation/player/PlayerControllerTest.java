package com.wildrifttracker.interfaces.http.presentation.player;

import com.wildrifttracker.core.usecases.player.RegisterPlayerUseCase;
import com.wildrifttracker.domain.dtos.player.CreatePlayerPayloadDto;
import com.wildrifttracker.domain.dtos.player.ReturnPlayerDto;
import com.wildrifttracker.infra.database.models.Player;
import com.wildrifttracker.interfaces.http.presentation.controllers.PlayerController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
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
        CreatePlayerPayloadDto playerPayload = new CreatePlayerPayloadDto("test");
        Player playerResult = new Player();

        playerResult.setNickname(playerPayload.nickname());

        Mockito.when(registerPlayerUseCase.create(playerPayload)).thenReturn(playerResult);

        ResponseEntity<ReturnPlayerDto> result = playerController.registerPlayer(playerPayload);

        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        assertEquals(playerResult.getNickname(), Objects.requireNonNull(result.getBody()).nickname());
    }
}
