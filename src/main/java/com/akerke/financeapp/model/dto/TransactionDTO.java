package com.akerke.financeapp.model.dto;

import com.akerke.financeapp.model.entity.Category;
import com.akerke.financeapp.model.entity.Transaction;
import com.akerke.financeapp.model.enums.TransactionType;

import java.math.BigDecimal;

public record TransactionDTO (
        Long userId,
        Long categoryId,
        TransactionType transactionType,
        BigDecimal amount
){
}
