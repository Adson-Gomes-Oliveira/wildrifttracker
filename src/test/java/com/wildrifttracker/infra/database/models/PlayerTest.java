package com.wildrifttracker.infra.database.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player();
    }

    @DisplayName("Testing prop: player_id")
    @Test
    void testSetAndGetPlayerId() {
        player.setPlayerId(123L);
        assertEquals(123L, player.getPlayerId());
    }

    @DisplayName("Testing prop: nickname")
    @Test
    void testSetAndGetNickname() {
        player.setNickname("TestPlayer");
        assertEquals("TestPlayer", player.getNickname());
    }
}
