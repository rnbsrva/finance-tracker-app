package com.akerke.financeapp.controller;

import com.akerke.financeapp.model.dto.UserDTO;
import com.akerke.financeapp.model.entity.User;
import com.akerke.financeapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;


@Controller
@SchemaMapping
@RequiredArgsConstructor
public class UserController{

    private final UserService userService;

    @QueryMapping()
    User me() {
        return userService.me();
    }

    @MutationMapping()
    void deleteUser(
            @Argument Long id
    ) {
        userService.delete(id);
    }

    @MutationMapping
    User updateUser(
            @Argument UserDTO userDTO,
            @Argument Long id
    ) {
       return userService.update(id, userDTO);
    }

    @MutationMapping
    User register(
            @Argument UserDTO userDTO
    ) {
        return userService.save(userDTO);
    }



}
