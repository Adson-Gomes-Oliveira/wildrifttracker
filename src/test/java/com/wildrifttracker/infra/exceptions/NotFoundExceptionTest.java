package com.wildrifttracker.infra.exceptions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Infra :: Exceptions :: NotFoundException")
public class NotFoundExceptionTest {
    @DisplayName("Testing error throw")
    @Test
    public void exceptionThrow() {
        NotFoundException exception = assertThrows(
                NotFoundException.class,
                () -> { throw new NotFoundException("Test error"); }
        );

        assertEquals("Test error", exception.getMessage());
        assertEquals("Not Found Exception", exception.getErrorName());
        assertEquals(HttpStatus.NOT_FOUND.value(), exception.getErrorCode());
    }
}
