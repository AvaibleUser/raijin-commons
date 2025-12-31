package edu.raijin.commons.infrastructure.adapter.messaging.event.scrum;

import java.time.LocalDate;
import java.util.UUID;

import edu.raijin.commons.domain.type.SprintStatus;
import edu.raijin.commons.infrastructure.adapter.messaging.event.shared.Audit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SprintEvent {

    private UUID id;

    private UUID projectId;

    private String name;

    private String description;

    private LocalDate startDate;

    private LocalDate endDate;

    @Builder.Default
    private SprintStatus status = SprintStatus.PENDING;

    private Audit audit;
}
