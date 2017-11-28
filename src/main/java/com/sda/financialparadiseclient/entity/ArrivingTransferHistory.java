package com.sda.financialparadiseclient.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class ArrivingTransferHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String bankAccountNumber;

    private Integer customerId;

    private LocalDateTime date;

    private BigDecimal amount;

    public ArrivingTransferHistory() {
    }
}
