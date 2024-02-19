package com.akerke.financeapp.service.impl;

import com.akerke.financeapp.common.mapper.BudgetMapper;
import com.akerke.financeapp.model.dto.BudgetDTO;
import com.akerke.financeapp.model.entity.Budget;
import com.akerke.financeapp.repository.BudgetRepository;
import com.akerke.financeapp.service.BudgetService;
import com.akerke.financeapp.service.CategoryService;
import com.akerke.financeapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BudgetServiceImpl implements BudgetService {

    private final BudgetMapper budgetMapper;
    private final CategoryService categoryService;
    private final BudgetRepository budgetRepository;
    private final UserService userService;

    @Override
    public Budget save(BudgetDTO budgetDTO) {
        var budget = budgetMapper.toModel(budgetDTO);

        var user = userService.getById(budgetDTO.userId());
        var category = categoryService.getById(budgetDTO.categoryId());

        budget.setCategory(category);
        budget.setUser(user);

        return budgetRepository.save(budget);
    }

    @Override
    public List<Budget> getAll() {
        return budgetRepository.findAll();
    }

    @Override
    public List<Budget> getAllByUserId(Long userId) {
        return budgetRepository.getBudgetsByUserId(userId);
    }

    @Override
    public Budget update(Long id, BudgetDTO budgetDTO) {
        var budget = budgetRepository.findByID(id);
        budgetMapper.update(budgetDTO, budget);
        return budgetRepository.save(budget);
    }

    @Override
    public void deleteAllByUserId(Long userId) {
        var budgets = budgetRepository.getBudgetsByUserId(userId);
        budgetRepository.deleteAll(budgets);
    }

    @Override
    public void delete(Long id) {
        var budget = budgetRepository.findByID(id);
        budgetRepository.delete(budget);
    }
}
