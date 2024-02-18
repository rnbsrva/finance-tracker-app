package com.akerke.financeapp.common.mapper;

import com.akerke.financeapp.model.dto.BudgetDTO;
import com.akerke.financeapp.model.entity.Budget;
import org.mapstruct.*;

@Mapper(
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface BudgetMapper {

    @Mapping(target = "isExceeded", expression = "java(false)")
    Budget toModel (BudgetDTO budgetDTO);

    @Mapping(target = "userId", expression = "java(budget.getUser().getId())")
    @Mapping(target = "categoryId", expression = "java(budget.getCategory().getId())")
    BudgetDTO toDTO (Budget budget);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "category", ignore = true)
    void update (BudgetDTO budgetDTO, @MappingTarget Budget budget);

}
