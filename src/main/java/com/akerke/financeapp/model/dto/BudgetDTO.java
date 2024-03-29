package com.akerke.financeapp.model.dto;

import java.math.BigDecimal;

public record BudgetDTO(
        Long userId,
        Long categoryId,
        BigDecimal limitAmount
) {
}
