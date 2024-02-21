package com.akerke.financeapp.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

//@Getter
//@Setter
////@DiscriminatorColumn(name="ACCOUNT_TYPE")
//public class AbstractAccount extends BaseEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String name;
//    private BigDecimal balance;
//
//
//    @ManyToOne
//    private User user;
//
//    @OneToMany(
//            mappedBy = "account",
//            cascade = CascadeType.ALL
//    )
//    private List<Transaction> transactions;
//}
