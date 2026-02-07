package com.wildrifttracker.core.usecases.player;

import com.wildrifttracker.infra.models.player.PlayerModel;
import com.wildrifttracker.interfaces.http.presentation.player.records.PlayerRequestRecord;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Use Case Test: Register Player")
public class RegisterPlayerUseCaseTest {
    @DisplayName("Testing method: Execute - Should create correct data")
    @Test
    public void executeTest() {
        PlayerRequestRecord payloadTest = new PlayerRequestRecord("lordcroft", "challenger");
        RegisterPlayerUseCase useCaseTest = new RegisterPlayerUseCase();
        PlayerModel useCaseResult = useCaseTest.execute(payloadTest);
        PlayerModel comparison = new PlayerModel();

        comparison.setPlayerId("123");
        comparison.setNickname(payloadTest.nickname());
        comparison.setTotalMatchs(0);
        comparison.setRank(payloadTest.rank());
        comparison.setVictoryCount(0);
        comparison.setDefeatCount(0);
        comparison.setWinRate(0);

        assertEquals("lordcroft", useCaseResult.getNickname());
        assertEquals("challenger", useCaseResult.getRank());
        assertEquals(0, useCaseResult.getTotalMatchs());
        assertEquals(0, useCaseResult.getVictoryCount());
        assertEquals(0, useCaseResult.getDefeatCount());
        assertEquals(0, useCaseResult.getWinRate());
        assertEquals("123", useCaseResult.getPlayerId());
    }
}
