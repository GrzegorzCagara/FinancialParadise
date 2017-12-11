package com.sda.financialparadiseclient.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sda.financialparadiseclient.handler.LocalDateTimeDeserializer;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Getter
@Setter
public class SuspiciousTransferHistory {

    private Integer id;
    private String bankAccountNumberFrom;
    private String bankAccountNumberTo;
    private String title;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime date;
    private BigDecimal amount;

    public SuspiciousTransferHistory() {
    }


}


