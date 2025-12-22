package edu.raijin.commons.infrastructure.adapter.messaging.event.scrum;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberEvent {

    private UUID projectId;

    private UUID userId;
}
