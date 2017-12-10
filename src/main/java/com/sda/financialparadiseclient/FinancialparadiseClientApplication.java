package com.sda.financialparadiseclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;
import java.util.Collections;

@SpringBootApplication
public class FinancialparadiseClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinancialparadiseClientApplication.class, args);
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

    @Bean
    public DriverManagerDataSource dataSource(){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
        driverManagerDataSource.setUrl("jdbc:postgresql://ec2-54-247-124-9.eu-west-1.compute.amazonaws.com:5432/df7stvvtr25t3i?sslmode=require");
        driverManagerDataSource.setUsername("ypcfzaahcckamo");
        driverManagerDataSource.setPassword("1b8a29b09cb5920eb4ae8049d867380e22e45f3a8153f845104e5289709fbd72");
        return driverManagerDataSource;
    }

	@Bean(name = "restTemplate")
	public RestTemplate getRestClient() {
		RestTemplate restClient = new RestTemplate(
				new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));
		return restClient;
	}
}

