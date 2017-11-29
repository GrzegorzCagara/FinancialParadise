package com.sda.financialparadiseclient.entity;

import lombok.Getter;
import lombok.Setter;


import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class DepartingTransferHistory {


    private Integer id;


    private Integer customerId;


    private String bankAccountNumber;

    private LocalDateTime date;

    private BigDecimal amount;

    public DepartingTransferHistory() {
    }

}
