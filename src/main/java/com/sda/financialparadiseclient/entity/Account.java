package com.sda.financialparadiseclient.entity;

import com.sda.financialparadiseclient.Currency;
import com.sda.financialparadiseclient.dto.Customer;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;


@Getter
@Setter
public class Account {


    private Integer id;
    private BigDecimal balance;
    private Currency currency;
    private Customer customer;

    public Account() {
    }

    public Account(BigDecimal balance, Currency currency, Customer customer) {
        this.balance = balance;
        this.currency = currency;
        this.customer = customer;
    }
}
