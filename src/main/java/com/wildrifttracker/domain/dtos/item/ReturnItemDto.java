package com.wildrifttracker.domain.dtos.item;

import com.wildrifttracker.infra.database.models.Item;

public record ReturnItemDto(
        String name,
        String attributes,
        int cost
) {
    public ReturnItemDto(Item item) {
        this(item.getName(), item.getAttributes(), item.getCost());
    }
}
