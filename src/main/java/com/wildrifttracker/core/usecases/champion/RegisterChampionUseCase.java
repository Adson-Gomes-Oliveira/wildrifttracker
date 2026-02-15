package com.wildrifttracker.core.usecases.champion;

import com.wildrifttracker.domain.dtos.champion.CreateChampionPayloadDto;
import com.wildrifttracker.infra.database.models.Champion;
import com.wildrifttracker.infra.database.repositories.ChampionRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class RegisterChampionUseCase {
    ChampionRepository championRepository;

    @Autowired
    public RegisterChampionUseCase(ChampionRepository championRepository) {
        this.championRepository = championRepository;
    }

    public Champion create(@Valid CreateChampionPayloadDto payload) {
        Champion championToCreate = new Champion();

        championToCreate.setName(payload.name());
        championToCreate.setRole(payload.role());
        championToCreate.setType(payload.type());
        championToCreate.setDifficultyLevel(payload.difficultyLevel());
        championToCreate.setRiotReferenceUrl(payload.riotReferenceUrl());

        return this.championRepository.save(championToCreate);
    }
}
