package com.wildrifttracker.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
public class IntegrationException extends RuntimeException {
    private final String errorName;
    private final HttpStatus errorCode;

    public IntegrationException(String message) {
        super(message);

        this.errorName = "Integration Exception";
        this.errorCode = HttpStatus.SERVICE_UNAVAILABLE;
    }

    public HttpStatus getErrorCode() {
        return errorCode;
    }

    public String getErrorName() {
        return errorName;
    }
}
