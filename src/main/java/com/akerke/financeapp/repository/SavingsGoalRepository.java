package com.akerke.financeapp.repository;

import com.akerke.financeapp.model.entity.SavingsGoal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingsGoalRepository extends JpaRepository<SavingsGoal, Long> {
}
