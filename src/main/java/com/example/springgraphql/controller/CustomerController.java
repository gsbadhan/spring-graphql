package com.example.springgraphql.controller;

import com.example.springgraphql.entity.Customer;
import com.example.springgraphql.pojo.NewCustomer;
import com.example.springgraphql.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

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

    @QueryMapping("getAllCustomers")
    public List<Customer> getCustomers() throws Exception {
        return customerService.getCustomers();
    }

    @MutationMapping("newCustomer")
    public Customer newCustomer(@Argument("record") NewCustomer customer) throws Exception {
        log.info("newCustomer request customer={}", customer);
        return customerService.newCustomer(customer);
    }

    @MutationMapping("updateCustomer")
    public Customer updateCustomer(@Argument("id") Long id, @Argument("record") NewCustomer customer) throws Exception {
        return customerService.updateCustomer(id, customer);
    }

    @MutationMapping("deleteCustomer")
    public Customer deleteCustomer(@Argument("id") Long id) throws Exception {
        return customerService.deleteCustomer(id);
    }

}
