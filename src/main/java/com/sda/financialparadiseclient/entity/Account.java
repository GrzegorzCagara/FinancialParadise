package com.sda.financialparadiseclient.entity;

import com.sda.spring.Currency;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Account {

    @Id
    @GeneratedValue
    private Integer id;
    private BigDecimal balance;
    private Currency currency;

    @OneToOne
    @Column(name = "customer_id")
    private Customer customer;

    public Account() {
    }

    public Account(BigDecimal balance, Currency currency, Customer customer) {
        this.balance = balance;
        this.currency = currency;
        this.customer = customer;
    }
}
