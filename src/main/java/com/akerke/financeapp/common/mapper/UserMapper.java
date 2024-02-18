package com.akerke.financeapp.common.mapper;

import com.akerke.financeapp.model.dto.UserDTO;
import com.akerke.financeapp.model.entity.*;
import org.mapstruct.*;

import java.util.ArrayList;

@Mapper(
        imports = {ArrayList.class, Transaction.class, Budget.class, SavingsGoal.class, Account.class, Category.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface UserMapper {

    @Mapping(target = "transactions", expression = "java(new ArrayList<Transaction>())")
    @Mapping(target = "accounts", expression = "java(new ArrayList<Account>())")
    @Mapping(target = "savingsGoals", expression = "java(new ArrayList<SavingsGoal>())")
    @Mapping(target = "budgets", expression = "java(new ArrayList<Budget>())")
    @Mapping(target = "categories", expression = "java(new ArrayList<Category>())")
    User toModel(UserDTO userDTO);

    UserDTO toDTO(User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "email", ignore = true)
    void update(UserDTO userDTO, @MappingTarget User user);

}