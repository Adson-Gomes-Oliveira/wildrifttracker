package com.wildrifttracker.infra.database.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    private Item item;

    @BeforeEach
    void setUp() {
        item = new Item();
    }

    @DisplayName("Testing prop: item_id")
    @Test
    void testSetAndGetItemId() {
        item.setItemId(1L);
        assertEquals(1L, item.getItemId());
    }

    @DisplayName("Testing prop: name")
    @Test
    void testSetAndGetName() {
        item.setName("Sword");
        assertEquals("Sword", item.getName());
    }

    @DisplayName("Testing prop: attributes")
    @Test
    void testSetAndGetAttributes() {
        item.setAttributes("Sharp, Legendary");
        assertEquals("Sharp, Legendary", item.getAttributes());
    }

    @DisplayName("Testing prop: cost")
    @Test
    void testSetAndGetCost() {
        item.setCost(100);
        assertEquals(100, item.getCost());
    }
}
