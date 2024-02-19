package com.akerke.financeapp.repository;

import com.akerke.financeapp.model.entity.SavingsGoal;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SavingsGoalRepository extends CommonRepository<SavingsGoal, Long> {

    @Override
    default Class<?> entityClass() {
        return SavingsGoal.class;
    }

    List<SavingsGoal> getSavingsGoalsByUserId(Long userId);
}
