package com.akerke.financeapp.service;

import com.akerke.financeapp.model.dto.TransactionDTO;
import com.akerke.financeapp.model.entity.Transaction;

import java.util.List;

public interface TransactionService {

    Transaction save(TransactionDTO transactionDTO);

    List<Transaction> getAll();

    List<Transaction> getAllByUserId(Long userId);

    Transaction getById(Long id);

    Transaction update(TransactionDTO transactionDTO);

    void delete(Long id);

}
