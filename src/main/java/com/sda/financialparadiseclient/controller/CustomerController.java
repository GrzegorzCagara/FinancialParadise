package com.sda.financialparadiseclient.controller;

import com.sda.financialparadiseclient.dto.Customer;
import com.sda.financialparadiseclient.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private Customer loggedCustomer;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    CustomerService customerService;

    @GetMapping("/find/all")
    public String users(ModelMap modelMap) throws Exception {
        //method 1
        //List<Map<String, Object>> userlist =  jdbcTemplate.queryForList("select * from users");

        List<Customer> userList = customerService.findAllCustomers();
        modelMap.addAttribute("customers", userList);
        return "customers";
    }


    @GetMapping("/customer")
    public String showForForAdd(Model model){
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "customer-form";
    }

    @PostMapping("/customer")
    public String saveCustomer(@Valid @ModelAttribute("customer") Customer customer,BindingResult bindingResult) throws Exception {
        if(bindingResult.hasErrors()){
            return "customer-form";
        }
        customerService.addCustomer(customer);
        return "redirect:/customers/find/all";
    }

    @PutMapping("/customer")
    public String sendUpdatedCustomer(@Valid @ModelAttribute("customer") Customer customer,BindingResult bindingResult) throws Exception {
        if(bindingResult.hasErrors()){
            return "redirect:/customers/update";
        }
        customerService.updateCustomer(customer);
        return "redirect:/customers/find/all";
    }

    @DeleteMapping("/customer")
    public String deleteCustomer(@RequestParam("customerId") int id) throws Exception {
        customerService.deleteCustomer(id);
        return "redirect:/customers/find/all";
    }

    @GetMapping("/update")
    public String updateCustomer(@RequestParam("customerId") int id, Model model) throws Exception {
        Customer customer = customerService.findCustomerById(id);
        model.addAttribute(customer);
        return "customer-update-form";
    }

    @GetMapping("/panel")
    public String customerPanel(){
        return "customer-panel";
    }

    @GetMapping("/panel/payment")
    public String sendTransfer(Model model){
        //trzeba zastąpic customera jakąś nowa klasą, która będzie odpowiadać obcej osobie do której wysyłamy przelew,
        //będzie ona zawierać: id, name, account number, adress(optional)
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "payment-form";
    }

    @PostMapping("/panel/payment")
    public String sendATransfer(){
        //logika do wysłania przelewu
        return "redirect:/customers/panel";
    }

}
