package com.wildrifttracker.domain.dtos.player;

import com.wildrifttracker.infra.database.models.Player;

public record ReturnPlayerDto(Long playerId, String nickname) {
    public ReturnPlayerDto(Player player) {
        this(player.getPlayerId(), player.getNickname());
    }
}
