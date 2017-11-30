package com.sda.financialparadiseclient.controller;

import com.sda.financialparadiseclient.entity.Customer;
import com.sda.financialparadiseclient.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    CustomerService customerService;

    @GetMapping("/customers")
    public String users(ModelMap modelMap){
        //method 1
        //List<Map<String, Object>> userlist =  jdbcTemplate.queryForList("select * from users");

        List<Customer> userList = jdbcTemplate.query("select * from customer",
                new BeanPropertyRowMapper<>(Customer.class));
        modelMap.addAttribute("customers", userList);
        return "customers";
    }



//    @RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
//    public String addUser(@ModelAttribute("firstName") String firstName,
//                          @ModelAttribute("lastName") String lastName,
//                          @ModelAttribute("pesel")  String pesel,
//                          @ModelAttribute("email") String email,
//                          @ModelAttribute("password") String password,
//                          ModelMap modelMap) throws Exception {
////        String sqluser =
////                String.format("INSERT INTO customer (first_name, last_name, pesel, email, password) VALUES ('%s', '%s', '%s', '%s', '%s')",
////                        customer.getFirstName(), customer.getLastName(), customer.getPesel(), customer.getEmail(), customer.getPassword());
////        jdbcTemplate.execute(sqluser);
////        String sqlrole =
////                String.format("INSERT INTO user_roles (username, role) VALUES ('%s', '%s')",
////                        username, "ROLE_ADMIN");
////        jdbcTemplate.execute(sqlrole);
//        List<Customer> customerList = jdbcTemplate.query("select * from customer",
//                new BeanPropertyRowMapper<>(Customer.class));
//
//        Customer customer = new Customer(firstName, lastName, pesel, email, password);
//        try {
//            customerService.addCustomer(customer);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
////        modelMap.addAttribute("customers", customerList);
//
//        return "redirect:/customers";
//    }

    @GetMapping("/showformforcustomer")
    public String showForForAdd(Model model){
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "customer-form";
    }

    @PostMapping("/addcustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) throws Exception {
        customerService.addCustomer(customer);
        return "redirect:/customers";
    }

}
