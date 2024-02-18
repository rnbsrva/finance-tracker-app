package com.akerke.financeapp.model.dto;

import java.math.BigDecimal;

public record AccountDTO(
        Long userId,
        String name,
        BigDecimal balance
) {
}
