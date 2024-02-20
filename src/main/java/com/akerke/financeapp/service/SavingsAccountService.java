package com.akerke.financeapp.service;

import com.akerke.financeapp.model.dto.SavingsAccountDTO;
import com.akerke.financeapp.model.entity.SavingsAccount;

import java.util.List;

public interface SavingsAccountService {

    SavingsAccount save (SavingsAccountDTO savingsAccountDTO);

    List<SavingsAccount> getAll();

    List<SavingsAccount> getAllByUserId(Long userId);

    SavingsAccount getById(Long id);

    SavingsAccount update(Long id, SavingsAccountDTO savingsAccountDTO);

    void delete(Long id);

}
