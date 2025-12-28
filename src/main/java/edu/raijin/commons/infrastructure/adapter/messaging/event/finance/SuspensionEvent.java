package edu.raijin.commons.infrastructure.adapter.messaging.event.finance;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SuspensionEvent {

    private Long id;

    private UUID employeeId;

    private BigDecimal amount;

    private String reason;

    private LocalDate startDate;

    private LocalDate endDate;

    private LocalDate transactionDate;
}
