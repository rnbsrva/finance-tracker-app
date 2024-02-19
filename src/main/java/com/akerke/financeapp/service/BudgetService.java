package com.akerke.financeapp.service;

import com.akerke.financeapp.model.dto.BudgetDTO;
import com.akerke.financeapp.model.entity.Budget;

import java.util.List;

public interface BudgetService {

    Budget save(BudgetDTO budgetDTO);

    List<Budget> getAll();

    List<Budget> getAllByUserId(Long userId);

    Budget update(Long id, BudgetDTO budgetDTO);

    void deleteAllByUserId(Long userId);

    void delete(Long id);

}
