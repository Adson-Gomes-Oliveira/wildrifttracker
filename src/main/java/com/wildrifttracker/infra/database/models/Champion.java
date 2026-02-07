package com.wildrifttracker.infra.database.models;

import jakarta.persistence.*;

@Entity
@Table(name = "champions")
public class Champion extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long championId;

    private String name;
    private String role;
    private String difficultyLevel;
    private String type;

    public Long getChampionId() {
        return championId;
    }

    public void setChampionId(Long championId) {
        this.championId = championId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRiotReferenceUrl() {
        return riotReferenceUrl;
    }

    public void setRiotReferenceUrl(String riotReferenceUrl) {
        this.riotReferenceUrl = riotReferenceUrl;
    }

    private String riotReferenceUrl;
}
