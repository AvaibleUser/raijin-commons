package edu.raijin.commons.infrastructure.adapter.messaging.event;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import edu.raijin.commons.domain.type.ProjectStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectEvent implements Serializable {

    private UUID id;

    private String name;

    private String description;

    private String client;

    @Builder.Default
    private ProjectStatus status = ProjectStatus.ACTIVE;

    @Builder.Default
    private BigDecimal monthlyIncome = BigDecimal.ZERO;
}
