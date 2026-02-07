package com.wildrifttracker.infra.models.player;

import java.util.TreeMap;

public class RankModel {
    String rank;
    int points;
    TreeMap<Integer, String> rankRefs;

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public TreeMap<Integer, String> getRankRefs() {
        return rankRefs;
    }

    public void setRankRefs(TreeMap<Integer, String> rankRefs) {
        this.rankRefs = rankRefs;
    }
}
