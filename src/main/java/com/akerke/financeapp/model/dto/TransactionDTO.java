package com.akerke.financeapp.model.dto;

import com.akerke.financeapp.model.enums.TransactionType;

import java.math.BigDecimal;

public record TransactionDTO (
        Long userId,
        Long categoryId,
        Long accountId,
        TransactionType transactionType,
        BigDecimal amount
){
}
