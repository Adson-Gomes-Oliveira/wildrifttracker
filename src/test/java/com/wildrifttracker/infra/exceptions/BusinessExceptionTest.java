package com.wildrifttracker.infra.exceptions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Infra Test: Business Exception")
public class BusinessExceptionTest {
    @DisplayName("Testing method: Error Throw - Should throw error with details")
    @Test
    public void exceptionThrowWithDetails() {
        String[] args = {"name", "wrong path"};
        HashMap<String, String> argsTest = new HashMap<>();

        argsTest.put(args[0], args[1]);

        BusinessException exception = assertThrows(
                BusinessException.class,
                () -> { throw new BusinessException("Test error", args); }
        );

        assertEquals("Test error", exception.getMessage());
        assertEquals("Business Exception", exception.getErrorName());
        assertEquals(HttpStatus.UNPROCESSABLE_ENTITY.value(), exception.getErrorCode());
        assertEquals(argsTest, exception.getDetails());
    }

    @DisplayName("Testing method: Error Throw - Should throw error without details")
    @Test
    public void exceptionThrowWithoutDetails() {
        String[] args = {};
        HashMap<String, String> argsTest = new HashMap<>();

        BusinessException exception = assertThrows(
                BusinessException.class,
                () -> { throw new BusinessException("Test error", args); }
        );

        assertEquals("Test error", exception.getMessage());
        assertEquals("Business Exception", exception.getErrorName());
        assertEquals(HttpStatus.UNPROCESSABLE_ENTITY.value(), exception.getErrorCode());
        assertEquals(argsTest, exception.getDetails());
    }

    @DisplayName("Testing method: Error Throw - Should not throw error with details when insufficient args")
    @Test
    public void exceptionThrowIncorrectArgs() {
        String[] args = {"name"};
        HashMap<String, String> argsTest = new HashMap<>();

        BusinessException exception = assertThrows(
                BusinessException.class,
                () -> { throw new BusinessException("Test error", args); }
        );

        assertEquals("Test error", exception.getMessage());
        assertEquals("Business Exception", exception.getErrorName());
        assertEquals(HttpStatus.UNPROCESSABLE_ENTITY.value(), exception.getErrorCode());
        assertEquals(argsTest, exception.getDetails());
    }
}
