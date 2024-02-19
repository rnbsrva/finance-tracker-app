package com.akerke.financeapp.repository;

import com.akerke.financeapp.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CommonRepository<User, Long> {

    @Override
    default Class<?> entityClass() {
        return User.class;
    }

    Optional<User> getUserByEmail(String email);

    boolean existsByEmail(String email);

}
