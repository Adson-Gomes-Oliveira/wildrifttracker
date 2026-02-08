package com.wildrifttracker.domain.utils;

import com.wildrifttracker.domain.dtos.player.ReturnPlayerDto;
import com.wildrifttracker.infra.database.models.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Domain :: Utils :: DataPreparerTest")
public class DataPreparerTest {
    @DisplayName("Testing method: sanitizeUniqueData")
    @Test
    public void sanitizeUniqueData() {
        Player playerModel = new Player();
        ReturnPlayerDto playerDto = DataPreparer.sanitizeUniqueData(ReturnPlayerDto::new, playerModel);

        assertEquals("com.wildrifttracker.domain.utils.DataPreparer", DataPreparer.class.getName());
        assertEquals(playerModel.getNickname(), playerDto.nickname());
        assertThat(playerDto, not(hasProperty("createdAt")));
        assertThat(playerDto, not(hasProperty("updatedAt")));
    }

    @DisplayName("Testing method: sanitizeListData")
    @Test
    public void sanitizeListData() {
        List<Player> playerModel = new ArrayList<>();

        playerModel.add(new Player());
        playerModel.add(new Player());

        List<ReturnPlayerDto> playerDto = DataPreparer.sanitizeListData(ReturnPlayerDto::new, playerModel);

        assertEquals(2, playerDto.size());
        assertEquals(playerModel.size(), playerDto.size());
        assertEquals(playerModel.get(0).getNickname(), playerDto.get(0).nickname());
        assertEquals(playerModel.get(0).getPlayerId(), playerDto.get(0).playerId());
        assertThat(playerDto.get(0), not(hasProperty("createdAt")));
        assertThat(playerDto.get(0), not(hasProperty("updatedAt")));
        assertThat(playerDto.get(1), not(hasProperty("createdAt")));
        assertThat(playerDto.get(1), not(hasProperty("updatedAt")));
    }
}
