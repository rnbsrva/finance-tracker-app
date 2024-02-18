package com.akerke.financeapp.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Budget extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Boolean isExceeded;

    private BigDecimal limitAmount;
    private BigDecimal moneySpent;

    @ManyToOne
    private Category category;

    @ManyToOne
    private User user;

}
