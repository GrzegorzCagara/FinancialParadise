package com.sda.financialparadiseclient.controller;

import com.sda.financialparadiseclient.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/customers")
    public String users(ModelMap modelMap){
        //method 1
        //List<Map<String, Object>> userlist =  jdbcTemplate.queryForList("select * from users");

        List<Customer> userList = jdbcTemplate.query("select * from customer",
                new BeanPropertyRowMapper<>(Customer.class));
        modelMap.addAttribute("customers", userList);
        return "customers";
    }

    @RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
    public String addUser(@ModelAttribute Customer customer,
                          ModelMap modelMap){
        String sqluser =
                String.format("INSERT INTO customer (first_name, last_name, pesel, email, password) VALUES ('%s', '%s', '%s', '%s', '%s')",
                        customer.getFirstName(), customer.getLastName(), customer.getPesel(), customer.getEmail(), customer.getPassword());
        jdbcTemplate.execute(sqluser);
//        String sqlrole =
//                String.format("INSERT INTO user_roles (username, role) VALUES ('%s', '%s')",
//                        username, "ROLE_ADMIN");
//        jdbcTemplate.execute(sqlrole);
        List<Customer> customerList = jdbcTemplate.query("select * from customer",
                new BeanPropertyRowMapper<>(Customer.class));
        modelMap.addAttribute("customers", customerList);

        return "redirect:/customers";
    }

}
