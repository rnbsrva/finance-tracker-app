package com.akerke.financeapp.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class SavingsAccount extends Account {

    private BigDecimal targetMoney;
    private LocalDate targetDate;
    private Boolean isAchieved;

}
