package edu.raijin.commons.infrastructure.adapter.rest.dto.scrum;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

import edu.raijin.commons.domain.type.ProjectStatus;

public record ProjectDto(
        UUID id,
        String name,
        String description,
        String client,
        ProjectStatus status,
        BigDecimal monthlyIncome,
        Instant createdAt,
        Instant updatedAt,
        Instant closedAt) {
}
