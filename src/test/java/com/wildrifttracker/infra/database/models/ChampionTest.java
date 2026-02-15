package com.wildrifttracker.infra.database.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Infra :: Database :: Models :: Champion")
class ChampionTest {
    @DisplayName("Testing prop: champion ID")
    @Test
    void shouldSetAndGetChampionId() {
        Champion champion = new Champion();
        champion.setChampionId(1L);

        assertThat(champion.getChampionId()).isEqualTo(1L);
    }

    @DisplayName("Testing prop: name")
    @Test
    void shouldSetAndGetName() {
        Champion champion = new Champion();
        champion.setName("Ahri");

        assertThat(champion.getName()).isEqualTo("Ahri");
    }

    @DisplayName("Testing prop: role")
    @Test
    void shouldSetAndGetRole() {
        Champion champion = new Champion();
        champion.setRole("Mage");

        assertThat(champion.getRole()).isEqualTo("Mage");
    }

    @DisplayName("Testing prop: difficulty_level")
    @Test
    void shouldSetAndGetDifficultyLevel() {
        Champion champion = new Champion();
        champion.setDifficultyLevel("Medium");

        assertThat(champion.getDifficultyLevel()).isEqualTo("Medium");
    }

    @DisplayName("Testing prop: type")
    @Test
    void shouldSetAndGetType() {
        Champion champion = new Champion();
        champion.setType("Ranged");

        assertThat(champion.getType()).isEqualTo("Ranged");
    }

    @DisplayName("Testing prop: riot_reference_url")
    @Test
    void shouldSetAndGetRiotReferenceUrl() {
        Champion champion = new Champion();
        champion.setRiotReferenceUrl("https://riotgames.com/champions/ahri");

        assertThat(champion.getRiotReferenceUrl())
                .isEqualTo("https://riotgames.com/champions/ahri");
    }
}
