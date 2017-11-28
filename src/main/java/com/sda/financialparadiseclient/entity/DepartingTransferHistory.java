package com.sda.financialparadiseclient.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "transfer_history")
public class DepartingTransferHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "number_bank_account")
    private String bankAccountNumber;

    private LocalDateTime date;

    private BigDecimal amount;

    public DepartingTransferHistory() {
    }

}
