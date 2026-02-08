package com.wildrifttracker.domain.dtos.user;

import com.wildrifttracker.infra.database.models.User;

public record ReturnUserDto(String name, String email) {
    public ReturnUserDto(User user) {
        this(user.getName(), user.getEmail());
    }
}
