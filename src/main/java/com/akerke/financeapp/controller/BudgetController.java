package com.akerke.financeapp.controller;

import com.akerke.financeapp.model.dto.BudgetDTO;
import com.akerke.financeapp.model.entity.Budget;
import com.akerke.financeapp.service.BudgetService;
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
public class BudgetController {

    private final BudgetService budgetService;


    @QueryMapping
    List<Budget> getBudgetsByUserId(
            @Argument Long id
    ){
        return budgetService.getAllByUserId(id);
    }

    @QueryMapping
    Budget getBudgetById(
            @Argument Long id
    ) {
        return budgetService.getById(id);
    }

    @MutationMapping
    Budget saveBudget(
            @Argument BudgetDTO budgetDTO
    ) {
        return budgetService.save(budgetDTO);
    }

    @MutationMapping
    Budget updateBudget(
            @Argument Long id,
            @Argument BudgetDTO budgetDTO
    ){
        return budgetService.update(id, budgetDTO);
    }

    @MutationMapping
    void deleteBudget(
            @Argument Long id
    ){
        budgetService.delete(id);
    }

}
