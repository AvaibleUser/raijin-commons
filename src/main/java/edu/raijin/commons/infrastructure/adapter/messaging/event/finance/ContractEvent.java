package edu.raijin.commons.infrastructure.adapter.messaging.event.finance;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import edu.raijin.commons.domain.type.ContractStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContractEvent {

    private UUID id;

    private UUID employeeId;

    private BigDecimal baseSalary;

    private String role;

    private LocalDate startDate;

    private LocalDate endDate;

    private ContractStatus status;
}
