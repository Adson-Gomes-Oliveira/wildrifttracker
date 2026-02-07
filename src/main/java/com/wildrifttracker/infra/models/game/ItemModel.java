package com.wildrifttracker.infra.models.game;

import java.util.ArrayList;

public class ItemModel {
    private final String name;
    private final double cost;
    private final String rank;
    private final ArrayList<String> attributes;

    public ItemModel(String name, double cost, ArrayList<String> attributes, String rank) {
        this.name = name;
        this.cost = cost;
        this.attributes = attributes;
        this.rank = rank;
    }

    public String getName() {
        return name;
    }
}
