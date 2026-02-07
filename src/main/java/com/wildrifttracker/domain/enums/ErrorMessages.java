package com.wildrifttracker.domain.enums;

public enum ErrorMessages {
    PLAYER_NOT_FOUND("player-not-found-with-id");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
