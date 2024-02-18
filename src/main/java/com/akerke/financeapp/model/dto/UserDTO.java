package com.akerke.financeapp.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserDTO {

    private String name;
    private String surname;
    private String email;
    private LocalDate birthDate;
    private String password;

}
