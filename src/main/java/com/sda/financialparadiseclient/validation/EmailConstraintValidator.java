package com.sda.financialparadiseclient.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class EmailConstraintValidator implements ConstraintValidator<EmailValidator, String> {

    private String email;

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public void initialize(EmailValidator emailValidator) {
        email = emailValidator.value();
    }


    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        String sql = "SELECT email FROM CUSTOMER WHERE email = '%s';";
        String statement = String.format(sql, s);
        List<String> customers = jdbcTemplate.queryForList(statement, String.class);
        if (customers.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
