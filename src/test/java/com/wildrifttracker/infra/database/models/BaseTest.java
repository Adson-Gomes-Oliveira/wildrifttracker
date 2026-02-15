package com.wildrifttracker.infra.database.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class BaseTest {
    static class TestEntity extends Base {}

    private TestEntity entity;

    @BeforeEach
    void setUp() {
        entity = new TestEntity();
    }

    @DisplayName("Testing prop: timestamps")
    @Test
    void testOnCreateSetsTimestamps() {
        entity.onCreate();

        LocalDateTime createdAt = entity.getCreatedAt();
        LocalDateTime updatedAt = entity.getUpdatedAt();

        assertNotNull(createdAt, "createdAt should not be null after onCreate");
        assertNotNull(updatedAt, "updatedAt should not be null after onCreate");
        assertEquals(createdAt, updatedAt, "createdAt and updatedAt should be equal after onCreate");
    }

    @DisplayName("Testing prop: creation")
    @Test
    void testOnUpdateUpdatesUpdatedAtOnly() throws InterruptedException {
        entity.onCreate();

        LocalDateTime createdAtBefore = entity.getCreatedAt();
        LocalDateTime updatedAtBefore = entity.getUpdatedAt();

        // Simulate delay
        Thread.sleep(10);

        entity.onUpdate();
        LocalDateTime createdAtAfter = entity.getCreatedAt();
        LocalDateTime updatedAtAfter = entity.getUpdatedAt();

        assertEquals(createdAtBefore, createdAtAfter, "createdAt should not change on update");
        assertNotEquals(updatedAtBefore, updatedAtAfter, "updatedAt should change on update");
        assertTrue(updatedAtAfter.isAfter(updatedAtBefore), "updatedAt should be after previous updatedAt");
    }
}
