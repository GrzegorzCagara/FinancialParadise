package com.sda.financialparadiseclient.entity;



import lombok.Getter;
import lombok.Setter;




@Getter
@Setter
public class Customer {


    private Integer id;

    private String firstName;

    private String lastName;
    
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
