package com.wildrifttracker.domain.dtos.champion;

import jakarta.validation.constraints.Size;

public record CreateChampionPayloadDto(
        @Size(max = 16) String name,
        @Size(max = 5) String role,
        @Size(max = 6) String difficultyLevel,
        @Size(max = 6) String type,
        String riotReferenceUrl
) {
}
