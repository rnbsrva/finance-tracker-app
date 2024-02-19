package com.akerke.financeapp.service.impl;

import com.akerke.financeapp.common.mapper.CategoryMapper;
import com.akerke.financeapp.model.dto.CategoryDTO;
import com.akerke.financeapp.model.entity.Category;
import com.akerke.financeapp.repository.CategoryRepository;
import com.akerke.financeapp.service.CategoryService;
import com.akerke.financeapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final UserService userService;
    private final CategoryMapper categoryMapper;

    @Override
    public Category save(CategoryDTO categoryDTO) {
        var category = categoryMapper.toModel(categoryDTO);
        var user = userService.getById(categoryDTO.userId());
        category.setUser(user);
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Category> getAllByUserId(Long userId) {
        return categoryRepository.findCategoriesByUserId(userId);
    }

    @Override
    public Category getById(Long id) {
        return categoryRepository.findByID(id);
    }

    @Override
    public Category update(Long id, CategoryDTO categoryDTO) {
        var category = categoryRepository.findByID(id);
        categoryMapper.update(categoryDTO, category);
        return categoryRepository.save(category);
    }

    @Override
    public void delete(Long id) {
        var category = categoryRepository.findByID(id);
        categoryRepository.delete(category);
    }
}
