package com.akerke.financeapp.controller;

import com.akerke.financeapp.model.dto.CategoryDTO;
import com.akerke.financeapp.model.entity.Category;
import com.akerke.financeapp.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@SchemaMapping
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @MutationMapping
    Category saveCategory(
            @Argument CategoryDTO categoryDTO
    ){
        return categoryService.save(categoryDTO);
    }

    @QueryMapping
    List<Category> getCategoriesByUserId(
            @Argument Long userId
    ) {
        return categoryService.getAllByUserId(userId);
    }

    @MutationMapping
    Category updateCategory(
            @Argument Long id,
            @Argument CategoryDTO categoryDTO
    ){
        return categoryService.update(id, categoryDTO);
    }

    @MutationMapping
    void deleteCategory(
            @Argument Long id
    ) {
        categoryService.delete(id);
    }




}
