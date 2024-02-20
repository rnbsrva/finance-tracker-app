package com.akerke.financeapp.repository;

import com.akerke.financeapp.model.entity.SavingsAccount;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SavingsAccountRepository extends CommonRepository<SavingsAccount, Long> {

    @Override
    default Class<?> entityClass() {
        return SavingsAccount.class;
    }

    List<SavingsAccount> getSavingsGoalsByUserId(Long userId);
}
