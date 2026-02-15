package com.wildrifttracker.interfaces.http.presentation.controllers;

import com.wildrifttracker.core.usecases.champion.RecoverChampionUseCase;
import com.wildrifttracker.core.usecases.champion.RegisterChampionUseCase;
import com.wildrifttracker.domain.dtos.champion.CreateChampionPayloadDto;
import com.wildrifttracker.domain.dtos.champion.ReturnChampionDto;
import com.wildrifttracker.domain.utils.DataPreparer;
import com.wildrifttracker.infra.database.models.Champion;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tracker/champion")
@Tag(name = "Champions")
public class ChampionController {
    private final RecoverChampionUseCase recoverChampionUseCase;
    private final RegisterChampionUseCase registerChampionUseCase;

    @Autowired
    public ChampionController(
            RegisterChampionUseCase registerChampionUseCase,
            RecoverChampionUseCase recoverChampionUseCase
    ) {
        this.recoverChampionUseCase = recoverChampionUseCase;
        this.registerChampionUseCase = registerChampionUseCase;
    }

    @GetMapping
    public ResponseEntity<List<ReturnChampionDto>> getAllChampions() {
        List<Champion> result = this.recoverChampionUseCase.getAll();

        List<ReturnChampionDto> resultSanitized = DataPreparer
                .sanitizeListData(ReturnChampionDto::new, result);

        return ResponseEntity.status(HttpStatus.OK).body(resultSanitized);
    }

    @GetMapping("/{championId}")
    public ResponseEntity<ReturnChampionDto> getChampionById(@PathVariable Long championId) {
        Champion result = this.recoverChampionUseCase.getById(championId);

        ReturnChampionDto resultSanitized = DataPreparer
                .sanitizeUniqueData(ReturnChampionDto::new, result);

        return ResponseEntity.status(HttpStatus.OK).body(resultSanitized);
    }

    @PostMapping("/register")
    public ResponseEntity<ReturnChampionDto> registerChampion(
            @RequestBody CreateChampionPayloadDto payload
    ) {
        Champion result = this.registerChampionUseCase.create(payload);

        ReturnChampionDto resultSanitized = DataPreparer
                .sanitizeUniqueData(ReturnChampionDto::new, result);

        return ResponseEntity.status(HttpStatus.CREATED).body(resultSanitized);
    }
}
