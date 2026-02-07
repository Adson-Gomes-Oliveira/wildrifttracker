package com.wildrifttracker.interfaces.http.presentation.common;

import com.wildrifttracker.infra.exceptions.BusinessException;
import com.wildrifttracker.infra.exceptions.ErrorException;
import com.wildrifttracker.infra.exceptions.IntegrationException;
import com.wildrifttracker.interfaces.http.presentation.controllers.ExceptionController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Interface Test: Exception Controller")
public class ExceptionControllerTest {
    @DisplayName("Testing method: handleBusinessException - Should correctly deal with Business Exceptions")
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

    @DisplayName("Testing method: handleIntegrationException - Should correctly deal with Integration Exceptions")
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
}
