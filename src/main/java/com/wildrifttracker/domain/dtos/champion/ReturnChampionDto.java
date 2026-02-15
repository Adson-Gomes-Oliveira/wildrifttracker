package com.wildrifttracker.domain.dtos.champion;

import com.wildrifttracker.infra.database.models.Champion;

public record ReturnChampionDto(
        String name,
        String role,
        String difficultyLevel,
        String type,
        String riotReferenceUrl
) {
    public ReturnChampionDto(Champion champion) {
        this(
                champion.getName(),
                champion.getRole(),
                champion.getDifficultyLevel(),
                champion.getType(),
                champion.getRiotReferenceUrl()
        );
    }
}
