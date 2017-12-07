package com.sda.financialparadiseclient.controller;

import com.sda.financialparadiseclient.dto.Customer;
import com.sda.financialparadiseclient.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/admin")
@Controller
public class AdminController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/customer-detail")
    public String customerDetailsForm(){
        return "customer-detail-form";
    }

    @PostMapping("/customer-detail")
    public String customerDetails(@RequestParam("email") String email, Model model){
        Customer customer = customerService.findCustomerByEmail(email);
        String result = String.format("ID: %d, First name: %s, Last name: %s, Email: %s, Pesel: %s, Account Number: %s," +
                        "Balance: %s, Currency: %s",
                customer.getId(), customer.getFirstName(), customer.getLastName(),
                customer.getEmail(), customer.getPesel(), customer.getAccount().getBankAccountNumber(),
                customer.getAccount().getBalance(), customer.getAccount().getCurrency());
        model.addAttribute("result", result);
        return "customer-detail-show";
    }
}
