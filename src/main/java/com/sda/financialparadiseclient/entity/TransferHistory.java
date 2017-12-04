package com.sda.financialparadiseclient.entity;


import lombok.Getter;
import lombok.Setter;


import java.math.BigDecimal;
import java.time.LocalDateTime;


@Getter
@Setter
public class TransferHistory {


    private Integer id;

    private String bankAccountNumberFrom;

    private String bankAccountNumberTo;

    private LocalDateTime date;

    private BigDecimal amount;

    public TransferHistory() {
    }

    public TransferHistory(String bankAccountNumberFrom, String bankAccountNumberTo, LocalDateTime date, BigDecimal amount) {
        this.bankAccountNumberFrom = bankAccountNumberFrom;
        this.bankAccountNumberTo = bankAccountNumberTo;
        this.date = date;
        this.amount = amount;
    }
}
