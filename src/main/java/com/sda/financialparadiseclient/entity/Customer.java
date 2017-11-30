package com.sda.financialparadiseclient.entity;




import com.sda.financialparadiseclient.validation.PeselValidator;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
@Setter
public class Customer {


    private Integer id;
    @NotNull
    private String firstName;

    private String lastName;
    @PeselValidator
    @Size(min = 11, max = 11)
    private String pesel;
    private String email;
    private String password;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String pesel, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.email = email;
        this.password = password;
    }
}
