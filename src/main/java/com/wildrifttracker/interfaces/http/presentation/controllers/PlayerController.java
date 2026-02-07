package com.wildrifttracker.interfaces.http.presentation.controllers;

import com.wildrifttracker.core.usecases.player.RegisterPlayerUseCase;
import com.wildrifttracker.domain.dtos.player.ReturnPlayerDto;
import com.wildrifttracker.domain.utils.DataPreparer;
import com.wildrifttracker.infra.database.models.Player;
import com.wildrifttracker.domain.dtos.player.CreatePlayerPayloadDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tracker/player")
@Tag(name = "Player")
public class PlayerController {
    private final RegisterPlayerUseCase registerPlayerUseCase;

    @Autowired
    public PlayerController(RegisterPlayerUseCase registerPlayerUseCase) {
        this.registerPlayerUseCase = registerPlayerUseCase;
    }

    @GetMapping
    public ResponseEntity<List<ReturnPlayerDto>> getAllPlayers() {
        List<Player> result = this.registerPlayerUseCase.getAll();

        List<ReturnPlayerDto> resultSanitized = DataPreparer
                .sanitizeListData(ReturnPlayerDto::new, result);

        return ResponseEntity.status(HttpStatus.OK).body(resultSanitized);
    }

    @GetMapping("/{playerId}")
    public ResponseEntity<ReturnPlayerDto> getPlayerById(@PathVariable Long playerId) {
        Player result = this.registerPlayerUseCase.getById(playerId);

        ReturnPlayerDto resultSanitized = DataPreparer
                .sanitizeUniqueData(ReturnPlayerDto::new, result);

        return ResponseEntity.status(HttpStatus.OK).body(resultSanitized);
    }

    @PostMapping("/register")
    public ResponseEntity<ReturnPlayerDto> registerPlayer(
            @RequestBody CreatePlayerPayloadDto payload
    ) {
        Player result = this.registerPlayerUseCase.create(payload);

        ReturnPlayerDto resultSanitized = DataPreparer
                .sanitizeUniqueData(ReturnPlayerDto::new, result);

        return ResponseEntity.status(HttpStatus.CREATED).body(resultSanitized);
    }
}
