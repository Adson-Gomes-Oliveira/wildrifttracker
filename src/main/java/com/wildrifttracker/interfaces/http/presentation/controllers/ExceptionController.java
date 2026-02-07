package com.wildrifttracker.interfaces.http.presentation.controllers;

import com.wildrifttracker.infra.exceptions.BusinessException;
import com.wildrifttracker.infra.exceptions.ErrorException;
import com.wildrifttracker.infra.exceptions.IntegrationException;
import com.wildrifttracker.infra.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler({BusinessException.class})
    public ResponseEntity<Object> handleBusinessException(BusinessException exception) {
        ErrorException error = new ErrorException(
                exception.getMessage(),
                exception.getErrorName(),
                exception.getErrorCode(),
                exception.getDetails()
        );

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(error);
    }

    @ExceptionHandler({IntegrationException.class})
    public ResponseEntity<Object> handleIntegrationException(IntegrationException exception) {
        ErrorException error = new ErrorException(
                exception.getMessage(),
                exception.getErrorName(),
                exception.getErrorCode(),
                new HashMap<>()
        );

        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(error);
    }

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<Object> handleNotFoundException(NotFoundException exception) {
        ErrorException error = new ErrorException(
                exception.getMessage(),
                exception.getErrorName(),
                exception.getErrorCode(),
                new HashMap<>()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleException(Exception exception) {
        ErrorException error = new ErrorException(
                exception.getMessage(),
                "",
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                new HashMap<>()
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}
