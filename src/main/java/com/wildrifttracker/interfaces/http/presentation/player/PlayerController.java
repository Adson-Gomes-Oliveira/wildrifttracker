package com.wildrifttracker.interfaces.http.presentation.player;

import com.wildrifttracker.core.usecases.player.RegisterPlayerUseCase;
import com.wildrifttracker.infra.models.player.PlayerModel;
import com.wildrifttracker.interfaces.http.presentation.player.records.PlayerRequestRecord;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tracker/player")
@Tag(name = "Player")
public class PlayerController {
    private final RegisterPlayerUseCase registerPlayerUseCase;

    @Autowired
    public PlayerController(RegisterPlayerUseCase registerPlayerUseCase) {
        this.registerPlayerUseCase = registerPlayerUseCase;
    }

    @PostMapping("/register")
    public ResponseEntity<PlayerModel> registerPlayer(@RequestBody PlayerRequestRecord payload) {
        PlayerModel result = this.registerPlayerUseCase.execute(payload);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}
