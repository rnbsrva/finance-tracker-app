package com.akerke.financeapp.repository;

import com.akerke.financeapp.model.entity.Account;
import com.akerke.financeapp.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
