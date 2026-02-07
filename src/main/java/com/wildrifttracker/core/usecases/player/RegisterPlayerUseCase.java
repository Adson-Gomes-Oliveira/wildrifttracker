package com.wildrifttracker.core.usecases.player;

import com.wildrifttracker.infra.models.player.PlayerModel;
import com.wildrifttracker.interfaces.http.presentation.player.records.PlayerRequestRecord;
import org.springframework.stereotype.Service;

@Service
public class RegisterPlayerUseCase {
    public PlayerModel execute(PlayerRequestRecord payload) {
        PlayerModel newPlayer = new PlayerModel();

        newPlayer.setPlayerId("123");
        newPlayer.setNickname(payload.nickname());
        newPlayer.setTotalMatchs(0);
        newPlayer.setRank(payload.rank());
        newPlayer.setVictoryCount(0);
        newPlayer.setDefeatCount(0);
        newPlayer.setWinRate(0);

        return newPlayer;
    }
}
