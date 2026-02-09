package com.wildrifttracker.interfaces.http.presentation.controllers;

import com.wildrifttracker.core.usecases.player.RegisterPlayerUseCase;
import com.wildrifttracker.core.usecases.player.RecoverPlayerUseCase;
import com.wildrifttracker.domain.dtos.player.CreatePlayerPayloadDto;
import com.wildrifttracker.domain.dtos.player.ReturnPlayerDto;
import com.wildrifttracker.infra.database.models.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Interfaces :: Http :: Presentation :: Controllers :: PlayerController")
class PlayerControllerTest {

    private PlayerController playerController;
    private RegisterPlayerUseCase registerPlayerUseCase;
    private RecoverPlayerUseCase recoverPlayerUseCase;

    @BeforeEach
    void setUp() {
        this.registerPlayerUseCase = Mockito.mock(RegisterPlayerUseCase.class);
        this.recoverPlayerUseCase = Mockito.mock(RecoverPlayerUseCase.class);
        this.playerController = new PlayerController(
                registerPlayerUseCase,
                recoverPlayerUseCase
        );
    }

    @DisplayName("Testing method: registerPlayer - Should receive a record and return a full player object")
    @Test
    void registerPlayer() {
        CreatePlayerPayloadDto playerPayload = new CreatePlayerPayloadDto("test");
        Player playerResult = new Player();

        playerResult.setNickname(playerPayload.nickname());

        Mockito.when(registerPlayerUseCase.create(playerPayload)).thenReturn(playerResult);

        ResponseEntity<ReturnPlayerDto> result = playerController.registerPlayer(playerPayload);

        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        assertEquals(playerResult.getNickname(), Objects.requireNonNull(result.getBody()).nickname());
    }

    @DisplayName("Testing method: getAllPlayers - Should return a list of player objects")
    @Test
    void getAllPlayers() {
        List<Player> playerResult = new ArrayList<>();
        playerResult.add(new Player());
        playerResult.add(new Player());

        Mockito.when(recoverPlayerUseCase.getAll()).thenReturn(playerResult);

        ResponseEntity<List<ReturnPlayerDto>> result = playerController.getAllPlayers();

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(playerResult.size(), Objects.requireNonNull(result.getBody()).size());
    }

    @DisplayName("Testing method: getPlayerById - Should return a player by id")
    @Test
    void getPlayerById() {
        Player playerResult = new Player();
        playerResult.setNickname("teste");

        Mockito.when(recoverPlayerUseCase.getById(123L)).thenReturn(playerResult);

        ResponseEntity<ReturnPlayerDto> result = playerController.getPlayerById(123L);

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(playerResult.getNickname(), Objects.requireNonNull(result.getBody()).nickname());
    }
}
