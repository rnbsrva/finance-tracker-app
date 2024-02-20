package com.akerke.financeapp.service.impl;

import com.akerke.financeapp.common.mapper.SavingsAccountMapper;
import com.akerke.financeapp.model.dto.SavingsAccountDTO;
import com.akerke.financeapp.model.entity.SavingsAccount;
import com.akerke.financeapp.repository.SavingsAccountRepository;
import com.akerke.financeapp.service.AccountService;
import com.akerke.financeapp.service.SavingsAccountService;
import com.akerke.financeapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SavingsAccountServiceImpl implements SavingsAccountService {

    private final SavingsAccountRepository savingsAccountRepository;
    private final UserService userService;
    private final SavingsAccountMapper savingsAccountMapper;

    @Override
    public SavingsAccount save(SavingsAccountDTO savingsAccountDTO) {
        var savingsGoal = savingsAccountMapper.toModel(savingsAccountDTO);

        var user = userService.getById(savingsAccountDTO.userId());
        savingsGoal.setUser(user);

        return savingsAccountRepository.save(savingsGoal);
    }

    @Override
    public List<SavingsAccount> getAll() {
        return savingsAccountRepository.findAll();
    }

    @Override
    public List<SavingsAccount> getAllByUserId(Long userId) {
        return savingsAccountRepository.getSavingsGoalsByUserId(userId);
    }

    @Override
    public SavingsAccount getById(Long id) {
        return savingsAccountRepository.findByID(id);
    }

    @Override
    public SavingsAccount update(Long id, SavingsAccountDTO savingsAccountDTO) {
        var savingsGoal = savingsAccountRepository.findByID(id);
        savingsAccountMapper.update(savingsAccountDTO, savingsGoal);
        return savingsAccountRepository.save(savingsGoal);
    }

    @Override
    public void delete(Long id) {
        var savingsGoal = savingsAccountRepository.findByID(id);
        savingsAccountRepository.delete(savingsGoal);
    }
}
