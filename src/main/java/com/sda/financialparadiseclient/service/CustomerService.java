package com.sda.financialparadiseclient.service;

import com.sda.financialparadiseclient.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Map;

@Service
public class CustomerService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${financial.service.url}")
    private String financialServiceUrl;

    public Map<String, String> addCustomer(Customer customer) throws Exception{
        URI uri = new URI(financialServiceUrl + "add");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();

        map.add("firstName", customer.getFirstName());
        map.add("lastName", customer.getLastName());
        map.add("pesel", customer.getPesel());
        map.add("email", customer.getEmail());
        map.add("password", customer.getPassword());

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity(map, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(uri, request, String.class);
        map.add("response", response.getBody());
        return map.toSingleValueMap();
    }

    public Map<String, String> updateCustomer(Customer customer) throws Exception{
        URI uri = new URI(financialServiceUrl + "update");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();

        map.add("firstName", customer.getFirstName());
        map.add("lastName", customer.getLastName());
        map.add("pesel", customer.getPesel());
        map.add("email", customer.getEmail());
        map.add("password", customer.getPassword());

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity(map, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(uri, request, String.class);
        map.add("response", response.getBody());
        return map.toSingleValueMap();
    }

    public Customer findCustomerById(int id) throws Exception{
        URI uri = new URI(financialServiceUrl + "find/" + id);
        Customer customer = restTemplate.getForObject(uri, Customer.class);
        return customer;
    }
}
