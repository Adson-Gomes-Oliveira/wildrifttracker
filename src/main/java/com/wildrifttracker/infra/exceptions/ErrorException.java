package com.wildrifttracker.infra.exceptions;

import org.springframework.http.HttpStatus;

import java.util.HashMap;

public record ErrorException(
        String message,
        String errorName,
        HttpStatus errorCode,
        HashMap<String, String> details
) {}
