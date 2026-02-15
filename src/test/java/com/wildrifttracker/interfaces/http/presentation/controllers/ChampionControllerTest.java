package com.wildrifttracker.interfaces.http.presentation.controllers;

import com.wildrifttracker.core.usecases.champion.RegisterChampionUseCase;
import com.wildrifttracker.core.usecases.champion.RecoverChampionUseCase;
import com.wildrifttracker.domain.dtos.champion.CreateChampionPayloadDto;
import com.wildrifttracker.domain.dtos.champion.ReturnChampionDto;
import com.wildrifttracker.infra.database.models.Champion;
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

@DisplayName("Interfaces :: Http :: Presentation :: Controllers :: ChampionController")
class ChampionControllerTest {

    private ChampionController championController;
    private RegisterChampionUseCase registerChampionUseCase;
    private RecoverChampionUseCase recoverChampionUseCase;

    @BeforeEach
    void setUp() {
        this.registerChampionUseCase = Mockito.mock(RegisterChampionUseCase.class);
        this.recoverChampionUseCase = Mockito.mock(RecoverChampionUseCase.class);
        this.championController = new ChampionController(
                registerChampionUseCase,
                recoverChampionUseCase
        );
    }

    @DisplayName("Testing method: registerChampion - Should receive a record and return a full champion object")
    @Test
    void registerChampion() {
        CreateChampionPayloadDto championPayload = new CreateChampionPayloadDto(
                "varus",
                "adc",
                "hard",
                "marksman",
                "https://riot.com"
        );

        Champion championResult = new Champion();
        championResult.setName(championPayload.name());

        Mockito.when(registerChampionUseCase.create(championPayload)).thenReturn(championResult);

        ResponseEntity<ReturnChampionDto> result = championController.registerChampion(championPayload);

        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        assertEquals(championResult.getName(), Objects.requireNonNull(result.getBody()).name());
    }

    @DisplayName("Testing method: getAllChampions")
    @Test
    void getAllChampions() {
        List<Champion> championResult = new ArrayList<>();
        championResult.add(new Champion());
        championResult.add(new Champion());

        Mockito.when(recoverChampionUseCase.getAll()).thenReturn(championResult);

        ResponseEntity<List<ReturnChampionDto>> result = championController.getAllChampions();

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(championResult.size(), Objects.requireNonNull(result.getBody()).size());
    }

    @DisplayName("Testing method: getChampionById")
    @Test
    void getChampionById() {
        Champion championResult = new Champion();
        championResult.setName("teste");

        Mockito.when(recoverChampionUseCase.getById(123L)).thenReturn(championResult);

        ResponseEntity<ReturnChampionDto> result = championController.getChampionById(123L);

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(championResult.getName(), Objects.requireNonNull(result.getBody()).name());
    }
}
