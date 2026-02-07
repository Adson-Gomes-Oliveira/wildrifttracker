package com.wildrifttracker.core.usecases.player;

import com.wildrifttracker.domain.enums.ErrorMessages;
import com.wildrifttracker.infra.database.models.Player;
import com.wildrifttracker.infra.database.repositories.PlayerRepository;
import com.wildrifttracker.domain.dtos.player.CreatePlayerPayloadDto;
import com.wildrifttracker.infra.exceptions.NotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class RegisterPlayerUseCase {
    private final PlayerRepository playerRepository;

    @Autowired
    public RegisterPlayerUseCase(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getAll() {
        return this.playerRepository.findAll();
    }

    public Player getById(Long playerId) {
        return this.playerRepository
                .findById(playerId)
                .orElseThrow(
                        () -> new NotFoundException(ErrorMessages.PLAYER_NOT_FOUND.getMessage())
                );
    }

    public Player create(@Valid CreatePlayerPayloadDto payload) {
        Player newPlayer = new Player();
        newPlayer.setNickname(payload.nickname());

        return this.playerRepository.save(newPlayer);
    }
}
