package com.wildrifttracker.infra.exceptions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Infra :: Exceptions :: IntegrationException")
public class IntegrationExceptionTest {
    @DisplayName("Testing error throw")
    @Test
    public void exceptionThrow() {
        IntegrationException exception = assertThrows(
                IntegrationException.class,
                () -> { throw new IntegrationException("Test error"); }
        );

        assertEquals("Test error", exception.getMessage());
        assertEquals("Integration Exception", exception.getErrorName());
        assertEquals(HttpStatus.SERVICE_UNAVAILABLE.value(), exception.getErrorCode());
    }
}
