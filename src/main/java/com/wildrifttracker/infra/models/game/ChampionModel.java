package com.wildrifttracker.infra.models.game;

public class ChampionModel {
    private final String name;
    private int totalMatchs;
    private int victoryCount;
    private int defeatCount;
    private double winRate;

    public ChampionModel(String name) {
        this.name = name;
    }

    /** Getters and Setters **/

    public String getName() {
        return name;
    }

    public double getWinRate() {
        return winRate;
    }

    /** Methods **/

    public void increaseTotalMatchs(int matchsQty, boolean isVictory) {
        this.totalMatchs += Math.max(matchsQty, 1);

        if (isVictory) {
            this.victoryCount += Math.max(matchsQty, 1);
        }

        this.defeatCount += Math.max(matchsQty, 1);
    }

    public void decreaseTotalMatchs(int matchsQty) {
        this.totalMatchs -= Math.max(matchsQty, 1);
    }

    public void calculateWinRate() {
        this.winRate = ((double) this.victoryCount / this.totalMatchs) * 100d;
    }
}
