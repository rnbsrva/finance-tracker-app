package com.akerke.financeapp.repository;

import com.akerke.financeapp.model.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CommonRepository<Transaction, Long> {

    @Override
    default Class<?> entityClass() {
        return Transaction.class;
    }
}
