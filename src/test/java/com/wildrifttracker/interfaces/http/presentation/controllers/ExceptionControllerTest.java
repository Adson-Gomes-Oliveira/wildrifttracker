package com.wildrifttracker.interfaces.http.presentation.controllers;

import com.wildrifttracker.infra.exceptions.BusinessException;
import com.wildrifttracker.infra.exceptions.ErrorException;
import com.wildrifttracker.infra.exceptions.IntegrationException;
import com.wildrifttracker.infra.exceptions.NotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Interfaces :: Http :: Presentation :: Controllers :: ExceptionController")
public class ExceptionControllerTest {
    @DisplayName("Testing method: handleBusinessException")
    @Test
    public void handleBusinessException() {
        String[] args = {};
        BusinessException error = new BusinessException("Error test", args);
        ExceptionController exceptionController = new ExceptionController();

        ErrorException errorResult = new ErrorException(
                error.getMessage(),
                error.getErrorName(),
                error.getErrorCode(),
                error.getDetails()
        );

        ResponseEntity<Object> result = exceptionController.handleBusinessException(error);

        assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, result.getStatusCode());
        assertEquals(errorResult, result.getBody());
    }

    @DisplayName("Testing method: handleIntegrationException")
    @Test
    public void handleIntegrationException() {
        IntegrationException error = new IntegrationException("Error test");
        ExceptionController exceptionController = new ExceptionController();

        ErrorException errorResult = new ErrorException(
                error.getMessage(),
                error.getErrorName(),
                error.getErrorCode(),
                new HashMap<>()
        );

        ResponseEntity<Object> result = exceptionController.handleIntegrationException(error);

        assertEquals(HttpStatus.SERVICE_UNAVAILABLE, result.getStatusCode());
        assertEquals(errorResult, result.getBody());
    }

    @DisplayName("Testing method: handleNotFoundException")
    @Test
    public void handleNotFoundException() {
        NotFoundException error = new NotFoundException("Error test");
        ExceptionController exceptionController = new ExceptionController();

        ErrorException errorResult = new ErrorException(
                error.getMessage(),
                error.getErrorName(),
                error.getErrorCode(),
                new HashMap<>()
        );

        ResponseEntity<Object> result = exceptionController.handleNotFoundException(error);

        assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
        assertEquals(errorResult, result.getBody());
    }

    @DisplayName("Testing method: handleException")
    @Test
    public void handleException() {
        Exception error = new Exception("Error test");
        ExceptionController exceptionController = new ExceptionController();

        ErrorException errorResult = new ErrorException(
                error.getMessage(),
                "",
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                new HashMap<>()
        );

        ResponseEntity<Object> result = exceptionController.handleException(error);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, result.getStatusCode());
        assertEquals(errorResult, result.getBody());
    }
}
