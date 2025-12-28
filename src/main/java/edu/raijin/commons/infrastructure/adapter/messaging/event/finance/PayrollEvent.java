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
public class PayrollEvent {

    private Long id;

    private UUID employeeId;

    private BigDecimal baseSalary;

    private BigDecimal totalBonuses;

    private BigDecimal totalDiscounts;

    private BigDecimal totalPaid;

    private LocalDate paymentDate;

    private LocalDate fromDate;

    private LocalDate toDate;
}
