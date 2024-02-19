package com.akerke.financeapp.repository;

import com.akerke.financeapp.model.entity.Account;
import com.akerke.financeapp.model.entity.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BudgetRepository extends CommonRepository<Budget, Long> {

    @Override
    default Class<?> entityClass() {
        return Budget.class;
    }

    List<Budget> getBudgetsByUserId(Long userId);

}
