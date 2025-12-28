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
public class BonusEvent {

    private Long id;

    private UUID employeeId;

    private BigDecimal amount;

    private BigDecimal oldAmount;

    private String reason;

    private LocalDate transactionDate;
}
