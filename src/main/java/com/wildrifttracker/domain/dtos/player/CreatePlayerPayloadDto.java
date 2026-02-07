package com.wildrifttracker.domain.dtos.player;

import jakarta.validation.constraints.Size;

public record CreatePlayerPayloadDto(@Size(max = 16) String nickname) {
}
