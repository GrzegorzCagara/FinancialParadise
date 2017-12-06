package com.sda.financialparadiseclient;

import com.sda.financialparadiseclient.dto.Account;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {

    private Account testedObject;

    @Before
    public void setUp() throws Exception {
        testedObject = Account.getAccount();
    }

    @Test
    public void shouldCreateObject() throws Exception {
        assertThat(testedObject).isNotNull();
        assertThat(testedObject.getCurrency()).isEqualTo(Currency.PLN);
        assertThat(testedObject.getBalance()).isEqualTo(new BigDecimal("50"));
        System.out.println(testedObject.getBankAccountNumber());
        assertThat(testedObject.getBankAccountNumber()).hasSize(26);
    }
}
