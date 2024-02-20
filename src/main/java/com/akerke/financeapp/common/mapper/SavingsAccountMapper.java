package com.akerke.financeapp.common.mapper;

import com.akerke.financeapp.model.dto.SavingsAccountDTO;
import com.akerke.financeapp.model.entity.Category;
import com.akerke.financeapp.model.entity.SavingsAccount;
import com.akerke.financeapp.model.entity.User;
import org.mapstruct.*;

import java.util.ArrayList;

@Mapper(imports = {ArrayList.class, Category.class, User.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface SavingsAccountMapper {

    @Mapping(target = "isAchieved", expression = "java(false)")
    SavingsAccount toModel(SavingsAccountDTO savingsAccountDTO);


    SavingsAccountDTO toDTO(SavingsAccount savingsAccount);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    void update(SavingsAccountDTO savingsAccountDTO, @MappingTarget SavingsAccount savingsAccount);

}
