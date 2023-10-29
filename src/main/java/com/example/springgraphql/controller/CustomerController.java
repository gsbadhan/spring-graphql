package com.example.springgraphql.controller;

import com.example.springgraphql.entity.Customer;
import com.example.springgraphql.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
@Slf4j
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @QueryMapping("getCustomerById")
    public Customer getCustomerById(@Argument Long id) throws Exception {
        log.info("getCustomerById request id={}", id);
        return customerService.getCustomer(id);
    }
}
