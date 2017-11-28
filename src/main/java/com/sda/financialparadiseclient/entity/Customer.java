package com.sda.financialparadiseclient.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
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
