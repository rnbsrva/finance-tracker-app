package com.akerke.financeapp.common.mapper;

import com.akerke.financeapp.model.dto.AccountDTO;
import com.akerke.financeapp.model.dto.TransactionDTO;
import com.akerke.financeapp.model.entity.Account;
import com.akerke.financeapp.model.entity.Category;
import com.akerke.financeapp.model.entity.Transaction;
import com.akerke.financeapp.model.entity.User;
import org.mapstruct.*;

import java.util.ArrayList;

@Mapper(
        imports = {ArrayList.class, Category.class, User.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface TransactionMapper {

    Transaction toModel(TransactionDTO transactionDTO);

    @Mapping(target = "userId", expression = "java(transaction.getUser().getId())")
    @Mapping(target = "categoryId", expression = "java(transaction.getCategory().getId())")
    TransactionDTO toDTO(Transaction transaction);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    void update(TransactionDTO transactionDTO, @MappingTarget Transaction transaction);

}