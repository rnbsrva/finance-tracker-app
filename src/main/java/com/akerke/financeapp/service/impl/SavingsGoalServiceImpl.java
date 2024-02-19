package com.akerke.financeapp.service.impl;

import com.akerke.financeapp.common.mapper.SavingsGoalMapper;
import com.akerke.financeapp.model.dto.SavingsGoalDTO;
import com.akerke.financeapp.model.entity.SavingsGoal;
import com.akerke.financeapp.repository.SavingsGoalRepository;
import com.akerke.financeapp.service.SavingsGoalService;
import com.akerke.financeapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SavingsGoalServiceImpl implements SavingsGoalService {

    private final SavingsGoalRepository savingsGoalRepository;
    private final UserService userService;
    private final SavingsGoalMapper savingsGoalMapper;

    @Override
    public SavingsGoal save(SavingsGoalDTO savingsGoalDTO) {
        var savingsGoal = savingsGoalMapper.toModel(savingsGoalDTO);
        var user = userService.getById(savingsGoalDTO.userId());
        savingsGoal.setUser(user);
        return savingsGoalRepository.save(savingsGoal);
    }

    @Override
    public List<SavingsGoal> getAll() {
        return savingsGoalRepository.findAll();
    }

    @Override
    public List<SavingsGoal> getAllByUserId(Long userId) {
        return savingsGoalRepository.getSavingsGoalsByUserId(userId);
    }

    @Override
    public SavingsGoal getById(Long id) {
        return savingsGoalRepository.findByID(id);
    }

    @Override
    public SavingsGoal update(Long id, SavingsGoalDTO savingsGoalDTO) {
        var savingsGoal = savingsGoalRepository.findByID(id);
        savingsGoalMapper.update(savingsGoalDTO, savingsGoal);
        return savingsGoalRepository.save(savingsGoal);
    }

    @Override
    public void delete(Long id) {
        var savingsGoal = savingsGoalRepository.findByID(id);
        savingsGoalRepository.delete(savingsGoal);
    }
}
