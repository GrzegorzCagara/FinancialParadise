package com.sda.financialparadiseclient.dto;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sda.financialparadiseclient.handler.LocalDateTimeDeserializer;
import com.sda.financialparadiseclient.handler.LocalDateTimeSerializer;
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

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime date;

    private BigDecimal amount;

    private String title;

    public TransferHistory() {
    }

    public TransferHistory(String bankAccountNumberFrom, String bankAccountNumberTo, LocalDateTime date, BigDecimal amount, String title) {
        this.bankAccountNumberFrom = bankAccountNumberFrom;
        this.bankAccountNumberTo = bankAccountNumberTo;
        this.date = date;
        this.amount = amount;
        this.title = title;
    }
}
