package com.akerke.financeapp.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class UserDTO {

    private String name;
    private String surname;
    private String username;
    private String email;

    public UserDTO(String name, String surname, String username, String email) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
    }


    public UserDTO() {
    }
}
