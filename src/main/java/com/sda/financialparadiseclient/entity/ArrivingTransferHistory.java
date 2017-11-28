package com.sda.financialparadiseclient.entity;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Getter
@Setter
public class ArrivingTransferHistory {


    private Integer id;

    private String bankAccountNumber;

    private Integer customerId;

    private LocalDateTime date;

    private BigDecimal amount;

    public ArrivingTransferHistory() {
    }
}
