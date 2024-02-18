package com.akerke.financeapp.common.mapper;

import com.akerke.financeapp.model.dto.CategoryDTO;
import com.akerke.financeapp.model.entity.Category;
import com.akerke.financeapp.model.entity.User;
import org.mapstruct.*;

import java.util.ArrayList;

@Mapper(
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface CategoryMapper {

    Category toModel (CategoryDTO categoryDTO);

    @Mapping(target = "userId", expression = "java(category.getUser().getId())")
    CategoryDTO toDTO (Category category);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    void update(CategoryDTO categoryDTO, @MappingTarget Category category);

}
