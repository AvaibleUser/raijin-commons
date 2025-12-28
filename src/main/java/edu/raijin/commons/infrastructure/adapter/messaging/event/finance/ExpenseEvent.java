package edu.raijin.commons.infrastructure.adapter.messaging.event.finance;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import edu.raijin.commons.domain.type.ExpenseType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseEvent {

    private Long id;

    private UUID projectId;

    private UUID employeeId;

    private String description;

    private BigDecimal amount;

    private ExpenseType type;

    private LocalDate expenseDate;
}
