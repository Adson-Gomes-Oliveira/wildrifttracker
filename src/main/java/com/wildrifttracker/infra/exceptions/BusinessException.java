package com.wildrifttracker.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
public class BusinessException extends RuntimeException {
    private final String errorName;
    private final int errorCode;
    private final HashMap<String, String> details;

    public BusinessException(String message, String[] args) {
        super(message);

        this.errorName = "Business Exception";
        this.errorCode = HttpStatus.UNPROCESSABLE_ENTITY.value();
        this.details = new HashMap<>();

        if (args.length % 2 == 0 && args.length != 0) {
            for (int index = 0; index < args.length; index += 2) {
                this.details.put(args[index], args[index + 1]);
            }
        }
    }

    public HashMap<String, String> getDetails() {
        return details;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorName() {
        return errorName;
    }
}
