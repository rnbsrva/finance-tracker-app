package com.akerke.financeapp.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "user_")
public class User  extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private String username;
    private String email;


    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL
    )
    private List<Transaction> transactions;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL
    )
    private List<Account> accounts;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL
    )
    private List<SavingsAccount> savingsAccounts;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL
    )
    private List<Budget> budgets;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL
    )
    private List<Category> categories;
}
