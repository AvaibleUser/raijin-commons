package edu.raijin.commons.infrastructure.adapter.messaging.event.scrum;

import java.util.UUID;

import edu.raijin.commons.domain.type.StoryPriority;
import edu.raijin.commons.infrastructure.adapter.messaging.event.shared.Audit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StoryEvent {

    private UUID id;

    private UUID projectId;

    private UUID productOwnerId;

    private UUID developerId;

    private UUID sprintId;

    private String name;

    private String description;

    private Integer points;

    private StoryPriority priority;

    private String stage;

    private Audit audit;
}
