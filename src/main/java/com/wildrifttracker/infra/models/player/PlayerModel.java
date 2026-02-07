package com.wildrifttracker.infra.models.player;


public class PlayerModel {
    private String playerId;
    private String nickname;
    private int totalMatchs;
    private int victoryCount;
    private int defeatCount;
    private double winRate;
    private String rank;

    public String getNickname() {
        return nickname;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getTotalMatchs() {
        return totalMatchs;
    }

    public void setTotalMatchs(int totalMatchs) {
        this.totalMatchs = totalMatchs;
    }

    public int getVictoryCount() {
        return victoryCount;
    }

    public void setVictoryCount(int victoryCount) {
        this.victoryCount = victoryCount;
    }

    public int getDefeatCount() {
        return defeatCount;
    }

    public void setDefeatCount(int defeatCount) {
        this.defeatCount = defeatCount;
    }

    public double getWinRate() {
        return winRate;
    }

    public void setWinRate(double winRate) {
        this.winRate = winRate;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
