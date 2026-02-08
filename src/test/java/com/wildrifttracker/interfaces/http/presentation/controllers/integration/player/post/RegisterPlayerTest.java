package com.wildrifttracker.interfaces.http.presentation.controllers.integration.player.post;

import com.wildrifttracker.interfaces.http.presentation.controllers.integration.configs.IntegrationRequests;
import com.wildrifttracker.domain.dtos.player.CreatePlayerPayloadDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@DisplayName("Integration test: Register a new player")
public class RegisterPlayerTest extends IntegrationRequests {
    @DisplayName("Register a new default player and return correct status code")
    @Test
    public void postNewPlayerTest() throws Exception {
        CreatePlayerPayloadDto playerRequest = new CreatePlayerPayloadDto("Test");
        post("/api/tracker/player/register", playerRequest).andExpect(MockMvcResultMatchers.status().isCreated());
    }
}
