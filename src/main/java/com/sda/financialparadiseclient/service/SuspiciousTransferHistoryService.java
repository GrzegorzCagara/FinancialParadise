package com.sda.financialparadiseclient.service;

import com.sda.financialparadiseclient.dto.SuspiciousTransferHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class SuspiciousTransferHistoryService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${financial.service.url}")
    private String financialServiceUrl;

    public List<SuspiciousTransferHistory> findAllSuspiciousTransfers() throws Exception {
        String url = financialServiceUrl + "suspicious/list";
        ParameterizedTypeReference<List<SuspiciousTransferHistory>> parameterizedTypereference = new ParameterizedTypeReference<List<SuspiciousTransferHistory>>() {
        };
        return restTemplate.exchange(url, HttpMethod.GET, null, parameterizedTypereference).getBody();
    }

}
