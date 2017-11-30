package com.sda.financialparadiseclient.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PeselConstraintValidator implements ConstraintValidator<PeselValidator, String> {

    private String pesel;

    @Override
    public void initialize(PeselValidator peselValidator) {
        pesel = peselValidator.value();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        int sum = (s.charAt(0)-48)*9 + (s.charAt(1)-48)*7 + (s.charAt(2)-48)*3 + (s.charAt(3)-48) + (s.charAt(4)-48)*9 +
                (s.charAt(5)-48)*7 + (s.charAt(6)-48)*3 + (s.charAt(7)-48) + (s.charAt(8)-48)*9 + (s.charAt(9)-48)*7;

        int result = sum%10;

        if (result == (s.charAt(10)-48)){
            return true;
        }
        return false;
    }
}
