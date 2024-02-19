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
    private String email;
    private LocalDate birthDate;

    public UserDTO(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }


    public UserDTO() {
    }
}
