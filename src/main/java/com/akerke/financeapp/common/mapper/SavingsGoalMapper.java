package com.akerke.financeapp.common.mapper;

import com.akerke.financeapp.model.dto.SavingsGoalDTO;
import com.akerke.financeapp.model.entity.Category;
import com.akerke.financeapp.model.entity.SavingsGoal;
import com.akerke.financeapp.model.entity.User;
import org.mapstruct.*;

import java.util.ArrayList;

@Mapper(imports = {ArrayList.class, Category.class, User.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface SavingsGoalMapper {

    @Mapping(target = "isAchieved", expression = "java(false)")
    @Mapping(target = "savedMoney", expression = "java(new BigDecimal(\"0\"))")
    SavingsGoal toModel(SavingsGoalDTO savingsGoalDTO);

    SavingsGoalDTO toDTO(SavingsGoal savingsGoal);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    void update(SavingsGoalDTO savingsGoalDTO, @MappingTarget SavingsGoal savingsGoal);

}
