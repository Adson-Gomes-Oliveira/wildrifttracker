package com.wildrifttracker.core.usecases.player;

import com.wildrifttracker.infra.database.models.Player;
import com.wildrifttracker.infra.database.repositories.PlayerRepository;
import com.wildrifttracker.domain.dtos.player.CreatePlayerPayloadDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class RegisterPlayerUseCase {
    private final PlayerRepository playerRepository;

    @Autowired
    public RegisterPlayerUseCase(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player create(@Valid CreatePlayerPayloadDto payload) {
        Player newPlayer = new Player();
        newPlayer.setNickname(payload.nickname());

        return this.playerRepository.save(newPlayer);
    }
}
