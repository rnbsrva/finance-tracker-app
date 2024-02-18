package com.akerke.financeapp.controller;

import com.akerke.financeapp.model.dto.UserDTO;
import com.akerke.financeapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;






}
