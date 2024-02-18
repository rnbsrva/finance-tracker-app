package com.akerke.financeapp.service.impl;

import com.akerke.financeapp.common.mapper.UserMapper;
import com.akerke.financeapp.model.dto.UserDTO;
import com.akerke.financeapp.model.entity.User;
import com.akerke.financeapp.repository.UserRepository;
import com.akerke.financeapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public User save(UserDTO userDTO) {
        var user = userMapper.toModel(userDTO);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Long id) {
        return userRepository.findByID(id);
    }

    @Override
    public User update(Long id, UserDTO userDTO) {
        var user = userRepository.findByID(id);
        userMapper.update(userDTO, user);
        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(userRepository.findByID(id));
    }
}
