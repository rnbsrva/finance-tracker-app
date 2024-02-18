package com.akerke.financeapp.service;

import com.akerke.financeapp.model.dto.SavingsGoalDTO;
import com.akerke.financeapp.model.entity.SavingsGoal;

import java.util.List;

public interface SavingsGoalService {

    SavingsGoal save (SavingsGoalDTO savingsGoalDTO);

    List<SavingsGoal> getAll();

    List<SavingsGoal> getAllByUserId(Long userId);

    SavingsGoal getById(Long id);

    SavingsGoal update(SavingsGoalDTO savingsGoalDTO);

    void delete(Long id);

}
