package com.sda.financialparadiseclient.controller;

import com.sda.financialparadiseclient.dto.Customer;
import com.sda.financialparadiseclient.dto.SuspiciousTransferHistory;
import com.sda.financialparadiseclient.service.CustomerService;
import com.sda.financialparadiseclient.service.SuspiciousTransferHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RequestMapping("/admin")
@Controller
public class AdminController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private SuspiciousTransferHistoryService suspiciousTransferHistoryService;

    @GetMapping("/panel")
    public String adminPanel() {
        return "admin-panel";
    }

    @GetMapping("/customer-details")
    public String customerDetailsForm(){
        return "admin-customer-details-form";
    }

    @PostMapping("/customer-details")
    public String customerDetails(@RequestParam("email") String email, Model model){
        Customer customer = customerService.findCustomerByEmail(email);
        if (customer == null){
            return "admin-customer-details-wrong-email";
        }
        String result = String.format("ID: %d\n First name: %s\n Last name: %s\n Email: %s\n Pesel: %s\n Account Number: %s\n" +
                        "Balance: %s, Currency: %s",
                customer.getId(), customer.getFirstName(), customer.getLastName(),
                customer.getEmail(), customer.getPesel(), customer.getAccount().getBankAccountNumber(),
                customer.getAccount().getBalance(), customer.getAccount().getCurrency());
        model.addAttribute("result", result);
        return "admin-customer-details-show";
    }

    @PutMapping("/customer")
    public String sendUpdatedCustomer(@Valid @ModelAttribute("customer") Customer customer,
                                      BindingResult bindingResult) throws Exception {
        if(bindingResult.hasErrors()){
            int id = customer.getId();
            return "redirect:/admin/update?customerId="+id;
        }
        customerService.updateCustomer(customer);
        return "redirect:/admin/find/all";
    }

    @DeleteMapping("/customer")
    public String deleteCustomer(@RequestParam("customerId") int id) throws Exception {
        customerService.deleteCustomer(id);
        return "redirect:/admin/find/all";
    }

    @GetMapping("/update")
    public String updateCustomer(@RequestParam("customerId") int id, Model model) throws Exception {
        Customer customer = customerService.findCustomerById(id);
        model.addAttribute(customer);
        return "admin-update-customer";
    }

    @GetMapping("/find/all")
    public String users(ModelMap model) throws Exception {
        List<Customer> userList = customerService.findAllCustomers();
        model.addAttribute("customers", userList);
        return "admin-customers";
    }

    @GetMapping("/suspicious-transfers")
    public String suspiciousTransferHistory(ModelMap model) throws Exception {
        List<SuspiciousTransferHistory> suspiciousTransferHistoryList = suspiciousTransferHistoryService.findAllSuspiciousTransfers();
        model.addAttribute("suspiciousTransfers", suspiciousTransferHistoryList);
        return "admin-suspicious-transfers";
    }
}
