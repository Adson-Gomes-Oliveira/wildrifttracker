package com.wildrifttracker.infra.models.game;

import java.util.ArrayList;
import java.util.List;

public class MatchModel {
    private final String date;
    private final int duration;
    private final String role;
    private final String lane;
    private final boolean isDuo;
    private final int totalKills;
    private final int totalDeaths;
    private final int myKills;
    private final int myDeaths;
    private final int myAssists;
    private final boolean isVictory;
    private final boolean tripleKill;
    private final boolean quadraKill;
    private final boolean pentaKill;
    private final boolean isMvp;
    private final boolean isWinAtRoutePhase;
    private final ArrayList<ItemModel> itemModels;
    private final ChampionModel championModel;

    public MatchModel(
            String date,
            int duration,
            String role,
            String lane,
            boolean isDuo,
            int totalKills,
            int totalDeaths,
            int myKills,
            int myDeaths,
            int myAssists,
            boolean isVictory,
            boolean tripleKill,
            boolean quadraKill,
            boolean pentaKill,
            boolean isMvp,
            boolean isWinAtRoutePhase,
            ArrayList<ItemModel> itemModels,
            ChampionModel championModel
    ) {
        this.date = date;
        this.duration = duration;
        this.role = role;
        this.lane = lane;
        this.isDuo = isDuo;
        this.totalKills = totalKills;
        this.totalDeaths = totalDeaths;
        this.myKills = myKills;
        this.myDeaths = myDeaths;
        this.myAssists = myAssists;
        this.isVictory = isVictory;
        this.tripleKill = tripleKill;
        this.quadraKill = quadraKill;
        this.pentaKill = pentaKill;
        this.isMvp = isMvp;
        this.isWinAtRoutePhase = isWinAtRoutePhase;
        this.itemModels = itemModels;
        this.championModel = championModel;
    }

    public ChampionModel getChampion() {
        return championModel;
    }

    public String getRole() {
        return role;
    }

    public boolean isVictory() {
        return isVictory;
    }

    public List<String> getItemNames() {
        return this.itemModels.stream().map(ItemModel::getName).toList();
    }
}
