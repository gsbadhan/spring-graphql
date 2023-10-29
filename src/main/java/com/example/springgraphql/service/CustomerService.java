package com.example.springgraphql.service;

import com.example.springgraphql.entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer getCustomer(Long id) throws Exception;

    List<Customer> getCustomers() throws Exception;

    Customer updateCustomer(Customer customer) throws Exception;
}
