package com.akerke.financeapp.model.dto;

import lombok.Data;

@Data
public class UserDTO {
    private String username;
    private String password;
    private String role;
}
