package com.wildrifttracker.domain.dtos.user;

import com.wildrifttracker.infra.database.models.User;

public record ReturnUserDto(Long userId, String name, String email) {
    public ReturnUserDto(User user) {
        this(user.getUserId(), user.getName(), user.getEmail());
    }
}
