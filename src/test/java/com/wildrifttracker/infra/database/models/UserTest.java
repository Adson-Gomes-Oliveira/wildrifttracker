package com.wildrifttracker.infra.database.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Infra :: Database :: Models :: User")
class UserTest {

    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
    }

    @DisplayName("Testing prop: user_id")
    @Test
    void testSetAndGetUserId() {
        user.setUserId(10L);
        assertEquals(10L, user.getUserId());
    }

    @DisplayName("Testing prop: name")
    @Test
    void testSetAndGetName() {
        user.setName("John Doe");
        assertEquals("John Doe", user.getName());
    }

    @DisplayName("Testing prop: email")
    @Test
    void testSetAndGetEmail() {
        user.setEmail("john.doe@email.com");
        assertEquals("john.doe@email.com", user.getEmail());
    }

    @DisplayName("Testing prop: password")
    @Test
    void testSetAndGetPassword() {
        user.setPassword("securePassword");
        assertEquals("securePassword", user.getPassword());
    }
}
