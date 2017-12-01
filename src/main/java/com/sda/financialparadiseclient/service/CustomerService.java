package com.sda.financialparadiseclient.service;

import com.sda.financialparadiseclient.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

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

    public Customer findCustomerById(int id) throws Exception {
        URI uri = new URI(financialServiceUrl  + id);
        Customer customer = restTemplate.getForObject(uri, Customer.class);
        return customer;
    }
}
