package com.akerke.financeapp.service.impl;

import com.akerke.financeapp.common.mapper.AccountMapper;
import com.akerke.financeapp.model.dto.AccountDTO;
import com.akerke.financeapp.model.entity.Account;
import com.akerke.financeapp.repository.AccountRepository;
import com.akerke.financeapp.service.AccountService;
import com.akerke.financeapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final UserService userService;
    private final AccountMapper accountMapper;


    @Override
    public Account save(AccountDTO accountDTO) {
        var account = accountMapper.toModel(accountDTO);
        var user = userService.getById(accountDTO.userId());
        account.setUser(user);
        return accountRepository.save(account);
    }

    @Override
    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    @Override
    public List<Account> getAllByUserId(Long userId) {
        return accountRepository.getAccountsByUserId(userId);
    }

    @Override
    public Account getById(Long id) {
        return accountRepository.findByID(id);
    }

    @Override
    public Account update(Long id, AccountDTO accountDTO) {
        var account = accountRepository.findByID(id);
        accountMapper.update(accountDTO, account);
        return accountRepository.save(account);
    }

    @Override
    public void deleteByUserId(Long userId) {
        var accounts = accountRepository.getAccountsByUserId(userId);
        accountRepository.deleteAll(accounts);
    }

    @Override
    public void delete(Long id) {
        var account = accountRepository.findByID(id);
        accountRepository.delete(account);
    }
}
