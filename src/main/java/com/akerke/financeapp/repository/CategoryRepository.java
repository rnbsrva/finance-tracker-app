package com.akerke.financeapp.repository;

import com.akerke.financeapp.model.entity.Account;
import com.akerke.financeapp.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CommonRepository<Category, Long> {

    @Override
    default Class<?> entityClass() {
        return Category.class;
    }

    List<Category> findCategoriesByUserId(Long userId);
}
