package com.sda.financialparadiseclient.service;

import com.sda.financialparadiseclient.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${financial.service.url}")
    private String financialServiceUrl;

    public void addCustomer(Customer customer) throws Exception {
        restTemplate.postForObject(financialServiceUrl, customer, String.class);
    }

    public void updateCustomer(Customer customer) throws Exception {
        restTemplate.put(financialServiceUrl, customer);
    }

    public void deleteCustomer(int id) throws Exception {
        restTemplate.delete(financialServiceUrl+ id);
    }

    public List<Customer> findAllCustomers() throws Exception {
        List<Customer> customers = restTemplate.getForObject(financialServiceUrl + "list", List.class);
        return customers;
    }

    public Customer findCustomerById(int id) throws Exception {
        Customer customer = restTemplate.getForObject(financialServiceUrl  + id, Customer.class);
        return customer;
    }
}
