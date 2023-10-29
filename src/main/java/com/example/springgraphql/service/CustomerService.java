package com.example.springgraphql.service;

import com.example.springgraphql.entity.Customer;

public interface CustomerService {
    Customer getCustomer(Long id) throws Exception;
}
