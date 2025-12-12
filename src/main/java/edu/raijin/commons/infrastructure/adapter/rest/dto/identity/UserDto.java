package edu.raijin.commons.infrastructure.adapter.rest.dto.identity;

import java.time.Instant;
import java.util.UUID;

public record UserDto(
        UUID id,
        String firstName,
        String lastName,
        String dpi,
        String email,
        String password,
        Instant createdAt,
        Instant updatedAt) {
}
