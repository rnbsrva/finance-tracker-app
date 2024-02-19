package com.akerke.financeapp.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record SavingsGoalDTO (
        Long userId,
        BigDecimal targetMoney,
        LocalDate targetDate
) {
}
