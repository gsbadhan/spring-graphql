package com.example.springgraphql.service;

import com.example.springgraphql.entity.Customer;
import com.example.springgraphql.pojo.NewCustomer;

import java.util.List;

public interface CustomerService {
    Customer getCustomer(Long id) throws Exception;

    List<Customer> getCustomers() throws Exception;

    Customer updateCustomer(Long id, NewCustomer newCustomer) throws Exception;

    Customer deleteCustomer(Long id) throws Exception;

    Customer newCustomer(NewCustomer newCustomer) throws Exception;

}
