package com.sda.financialparadiseclient.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.sda.financialparadiseclient.dto.Customer;
import com.sda.financialparadiseclient.dto.CustomerWithTransferReceiver;
import com.sda.financialparadiseclient.dto.TransferHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
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
        restTemplate.delete(financialServiceUrl + id);
    }

    public List<Customer> findAllCustomers() throws Exception {
        List<Customer> customers = restTemplate.getForObject(financialServiceUrl + "list", List.class);
        return customers;
    }

    public Customer findCustomerById(int id) throws Exception {
        Customer customer = restTemplate.getForObject(financialServiceUrl + id, Customer.class);
        return customer;
    }

    public void sendMoney(CustomerWithTransferReceiver customerWithTransferReceiver) {
        restTemplate.postForObject("http://localhost:8081/v1/transfer", customerWithTransferReceiver, String.class);
    }

    public Customer findCustomerByEmail(String email) {
        Customer customer = restTemplate.getForObject(financialServiceUrl + "/send" + email, Customer.class);
        return customer;
    }

    public List<TransferHistory> findAllTransferHistoryForSpecificAccount(String accountNumber) throws Exception {
        ParameterizedTypeReference<List<TransferHistory>> parameterizedTypereference = new ParameterizedTypeReference<List<TransferHistory>>() {
        };
        String url = financialServiceUrl + "/history/list" + accountNumber;
        return restTemplate.exchange(url, HttpMethod.GET, null, parameterizedTypereference).getBody();
    }


}
