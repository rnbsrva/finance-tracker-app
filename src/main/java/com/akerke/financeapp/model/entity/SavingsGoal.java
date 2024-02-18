package com.akerke.financeapp.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class SavingsGoal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal targetMoney;
    private LocalDate targetDate;
    private BigDecimal savedMoney;
    private Boolean isAchieved;

    @ManyToOne
    private User user;
}
