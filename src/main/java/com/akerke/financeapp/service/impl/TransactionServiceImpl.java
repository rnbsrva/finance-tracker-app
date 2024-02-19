package com.akerke.financeapp.service.impl;

import com.akerke.financeapp.common.mapper.TransactionMapper;
import com.akerke.financeapp.model.dto.TransactionDTO;
import com.akerke.financeapp.model.entity.Transaction;
import com.akerke.financeapp.repository.TransactionRepository;
import com.akerke.financeapp.service.CategoryService;
import com.akerke.financeapp.service.TransactionService;
import com.akerke.financeapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final UserService userService;
    private final CategoryService categoryService;
    private final TransactionMapper transactionMapper;

    @Override
    public Transaction save(TransactionDTO transactionDTO) {
        var transaction = transactionMapper.toModel(transactionDTO);

        var user = userService.getById(transactionDTO.userId());
        var category = categoryService.getById(transactionDTO.categoryId());

        transaction.setUser(user);
        transaction.setCategory(category);

        return transaction;
    }

    @Override
    public List<Transaction> getAll() {
        return transactionRepository.findAll();
    }

    @Override
    public List<Transaction> getAllByUserId(Long userId) {
        return transactionRepository.getTransactionsByUserId(userId);
    }

    @Override
    public Transaction getById(Long id) {
        return transactionRepository.findByID(id);
    }

    @Override
    public Transaction update(Long id, TransactionDTO transactionDTO) {
        var transaction = transactionRepository.findByID(id);
        transactionMapper.update(transactionDTO, transaction);
        return transactionRepository.save(transaction);
    }

    @Override
    public void delete(Long id) {
        var transaction = transactionRepository.findByID(id);
        transactionRepository.delete(transaction);
    }
}
