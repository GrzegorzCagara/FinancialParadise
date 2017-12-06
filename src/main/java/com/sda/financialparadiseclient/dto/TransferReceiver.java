package com.sda.financialparadiseclient.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class TransferReceiver {


    private String name;
    private String bankAccountNumber;
    private String title;
    private BigDecimal amount;

    public TransferReceiver() {}
}
