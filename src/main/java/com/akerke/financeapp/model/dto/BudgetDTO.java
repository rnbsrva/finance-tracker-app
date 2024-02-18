package com.akerke.financeapp.model.dto;

import java.math.BigDecimal;

public record BudgetDTO(
        BigDecimal limit,
        Long categoryId
) {
}
