package com.akerke.financeapp.controller;

import com.akerke.financeapp.model.dto.AccountDTO;
import com.akerke.financeapp.model.entity.Account;
import com.akerke.financeapp.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@SchemaMapping
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @QueryMapping
    List<Account> getAccountsByUserId(
            @Argument Long userId
    ) {
        return accountService.getAllByUserId(userId);
    }

    @QueryMapping
    Account getAccountById (
            @Argument Long id
    ){
        return accountService.getById(id);
    }

    @MutationMapping
    Account saveAccount(
            @Argument AccountDTO accountDTO
            ){
        return accountService.save(accountDTO);
    }

    @MutationMapping
    Account updateAccount(
            @Argument Long id,
            @Argument AccountDTO accountDTO
    ){
        return accountService.update(id, accountDTO);
    }

    @MutationMapping
    void deleteAccount(
            @Argument Long id
    ){
        accountService.delete(id);
    }



}
