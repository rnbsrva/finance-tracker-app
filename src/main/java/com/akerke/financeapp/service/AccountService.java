package com.akerke.financeapp.service;

import com.akerke.financeapp.model.dto.AccountDTO;
import com.akerke.financeapp.model.entity.Account;

import java.util.List;

public interface AccountService {

    Account save (AccountDTO accountDTO);

    List<Account> getAll();

    List<Account> getAllByUserId(Long userId);

    Account getById(Long id);

    Account update(Long id, AccountDTO accountDTO);

    void deleteByUserId(Long userId);

    void delete (Long id);

}
