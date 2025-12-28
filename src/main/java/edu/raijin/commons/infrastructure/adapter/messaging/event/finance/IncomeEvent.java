package edu.raijin.commons.infrastructure.adapter.messaging.event.finance;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import edu.raijin.commons.domain.type.IncomeType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IncomeEvent {

    private Long id;

    private UUID projectId;

    private BigDecimal amount;

    private IncomeType type;

    private String description;

    private LocalDate billingDate;
}
