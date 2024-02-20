package com.akerke.financeapp.controller;

import com.akerke.financeapp.model.dto.SavingsAccountDTO;
import com.akerke.financeapp.model.entity.SavingsAccount;
import com.akerke.financeapp.service.SavingsAccountService;
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
public class SavingsAccountController {

    private final SavingsAccountService savingsAccountService;

    @MutationMapping
    SavingsAccount saveSavingsAccount(
            @Argument SavingsAccountDTO savingsAccountDTO
            ){
        return savingsAccountService.save(savingsAccountDTO);
    }

    @QueryMapping
    SavingsAccount getSavingsAccountById(
            @Argument Long id
    ) {
        return savingsAccountService.getById(id);
    }

    @QueryMapping
    List<SavingsAccount> getSavingsAccountByUserId(
            @Argument Long userId
    ) {
        return savingsAccountService.getAllByUserId(userId);
    }

    @MutationMapping
    SavingsAccount updateSavingsAccount(
            @Argument Long id,
            @Argument SavingsAccountDTO savingsAccountDTO
    ) {
        return savingsAccountService.update(id, savingsAccountDTO);
    }

    @MutationMapping
    void deleteSavingsAccount (
            @Argument Long id
    ) {
        savingsAccountService.delete(id);
    }



}
