package com.wildrifttracker.domain.dtos.item;

import jakarta.validation.constraints.Size;

public record CreateItemPayloadDto(
        @Size(max = 16) String name,
        String attributes,
        int cost
) {
}
