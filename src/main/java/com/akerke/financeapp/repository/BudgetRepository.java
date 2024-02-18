package com.akerke.financeapp.repository;

import com.akerke.financeapp.model.entity.Account;
import com.akerke.financeapp.model.entity.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, Long> {
}