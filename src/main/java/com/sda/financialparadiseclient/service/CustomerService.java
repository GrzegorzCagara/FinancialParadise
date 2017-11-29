package com.sda.financialparadiseclient.service;

import com.sda.financialparadiseclient.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

    public Map<String, String> addCustomer(Customer customer) throws Exception{
        URI uri = new URI("http://localhost:8081/customers/add");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("id", String.valueOf(customer.getId()));
        map.add("firstname", customer.getFirstName());
        map.add("lastname", customer.getLastName());
        map.add("pesel", customer.getLastName());
        map.add("email", customer.getEmail());
        map.add("password", customer.getPassword());
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity(map, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(uri, request, String.class);
        map.add("response", response.getBody());
        return map.toSingleValueMap();
    }
}
