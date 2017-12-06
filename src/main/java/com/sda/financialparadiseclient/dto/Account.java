package com.sda.financialparadiseclient.dto;

import com.sda.financialparadiseclient.Currency;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.Random;


@Getter
@Setter
public class Account {


    private Integer id;
    private BigDecimal balance;
    private Currency currency;
    private String bankAccountNumber;

    private Account() {
    }

    private Account(BigDecimal balance, Currency currency, String bankAccountNumber) {
        this.balance = balance;
        this.currency = currency;
        this.bankAccountNumber = bankAccountNumber;
    }

    public static Account getAccount() {
        Random random = new Random();
        StringBuilder accountNumberBuilder = new StringBuilder();
        int number;
        for(int i = 0; i < 26; i++) {
            number = random.nextInt(10);
            accountNumberBuilder.append(number);
        }
        String accountNumber = accountNumberBuilder.toString();

        return new Account(new BigDecimal("50"), Currency.PLN, accountNumber);
    }
}
