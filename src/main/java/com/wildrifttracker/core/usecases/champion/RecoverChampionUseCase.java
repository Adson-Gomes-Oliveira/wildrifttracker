package com.wildrifttracker.core.usecases.champion;

import com.wildrifttracker.domain.enums.ErrorMessages;
import com.wildrifttracker.infra.database.models.Champion;
import com.wildrifttracker.infra.database.repositories.ChampionRepository;
import com.wildrifttracker.infra.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class RecoverChampionUseCase {
    ChampionRepository championRepository;

    @Autowired
    public RecoverChampionUseCase(ChampionRepository championRepository) {
        this.championRepository = championRepository;
    }

    public List<Champion> getAll() {
        return this.championRepository.findAll();
    }

    public Champion getById(Long userId) {
        return this.championRepository
                .findById(userId)
                .orElseThrow(
                        () -> new NotFoundException(ErrorMessages.PLAYER_NOT_FOUND.getMessage())
                );
    }
}
