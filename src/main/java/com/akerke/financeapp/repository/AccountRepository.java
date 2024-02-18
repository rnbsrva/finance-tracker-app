package com.akerke.financeapp.repository;

import com.akerke.financeapp.model.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CommonRepository<Account, Long> {

    @Override
    default Class<?> entityClass() {
        return Account.class;
    }
}
