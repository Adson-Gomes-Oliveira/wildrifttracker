package com.wildrifttracker.core.integration.player.post;

import com.wildrifttracker.core.integration.configs.IntegrationRequests;
import com.wildrifttracker.interfaces.http.presentation.player.records.PlayerRequestRecord;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@DisplayName("Integration test: Register a new player")
public class RegisterPlayerTest extends IntegrationRequests {
    @DisplayName("Register a new default player and return correct status code")
    @Test
    public void postNewPlayerTest() throws Exception {
        PlayerRequestRecord playerRequest = new PlayerRequestRecord("Test", "Test");
        post("/api/tracker/player/register", playerRequest).andExpect(MockMvcResultMatchers.status().isCreated());
    }
}
