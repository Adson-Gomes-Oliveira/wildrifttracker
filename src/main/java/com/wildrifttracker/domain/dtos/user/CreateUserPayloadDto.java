package com.wildrifttracker.domain.dtos.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record CreateUserPayloadDto(
        @Size(max = 16) String name,
        @Email String email,
        @Size(max = 16) String password
) {
}
