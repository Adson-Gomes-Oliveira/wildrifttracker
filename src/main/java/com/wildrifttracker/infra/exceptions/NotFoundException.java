package com.wildrifttracker.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
    private final String errorName;
    private final int errorCode;

    public NotFoundException(String message) {
        super(message);

        this.errorName = "Not Found Exception";
        this.errorCode = HttpStatus.NOT_FOUND.value();
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorName() {
        return errorName;
    }
}
