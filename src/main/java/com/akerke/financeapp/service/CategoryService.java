package com.akerke.financeapp.service;

import com.akerke.financeapp.model.dto.CategoryDTO;
import com.akerke.financeapp.model.entity.Category;

import java.util.List;

public interface CategoryService {

    Category save(CategoryDTO categoryDTO);

    List<Category> getAll();

    List<Category> getAllByUserId(Long userId);

    Category getById(Long id);

    Category update(Long id, CategoryDTO categoryDTO);

    void delete(Long id);

}
