package edu.raijin.commons.infrastructure.adapter.messaging.event.shared;

import java.time.Instant;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Audit {

    private String eventType;

    private UUID actorId;

    @Builder.Default
    private Instant occurredAt = Instant.now();

    private String description;
}
