package com.akerke.financeapp.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class SavingsGoal extends Account {

    private BigDecimal targetMoney;
    private LocalDate targetDate;
    private Boolean isAchieved;

    @ManyToOne
    private User user;
}
