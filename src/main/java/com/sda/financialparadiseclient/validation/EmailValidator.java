package com.sda.financialparadiseclient.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = EmailConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailValidator {

    public String value() default "";

    public String message() default "Email already exists in our database";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};
}
