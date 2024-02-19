package com.akerke.financeapp.controller;

import com.akerke.financeapp.model.dto.TransactionDTO;
import com.akerke.financeapp.model.entity.Transaction;
import com.akerke.financeapp.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@SchemaMapping
@Controller
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @MutationMapping
    Transaction saveTransaction(
            @Argument TransactionDTO transactionDTO
            ){
        return transactionService.save(transactionDTO);
    }

    @QueryMapping
    Transaction getTransactionById(
            @Argument Long id
    ) {
        return transactionService.getById(id);
    }

    @MutationMapping
    Transaction updateTransaction(
            @Argument Long id,
            @Argument TransactionDTO transactionDTO
    ){
        return transactionService.update(id, transactionDTO);
    }

    @MutationMapping
    void deleteTransaction (
            @Argument Long id
    ){
        transactionService.delete(id);
    }

    @QueryMapping
    List<Transaction> getTransactionsByUserId (
            @Argument Long userId
    ) {
        return transactionService.getAllByUserId(userId);
    }


}
