package com.akerke.financeapp.service;


import com.akerke.financeapp.model.dto.UserDTO;
import com.akerke.financeapp.model.entity.User;
import com.akerke.financeapp.repository.UserRepository;

import java.util.List;

public interface UserService {

    User save(UserDTO userDTO);

    List<User> getAll();

    User getById(Long id);

    User update(UserDTO userDTO);

    void delete (Long id);

}
