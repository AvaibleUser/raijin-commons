package edu.raijin.commons.infrastructure.adapter.rest.dto.scrum;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public record ProjectDto(
        UUID id,
        String name,
        String description,
        String client,
        Boolean active,
        BigDecimal monthlyIncome,
        Instant createdAt,
        Instant updatedAt,
        Instant closedAt) {
}
