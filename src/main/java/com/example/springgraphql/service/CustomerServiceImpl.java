package com.example.springgraphql.service;

import com.example.springgraphql.entity.Customer;
import com.example.springgraphql.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer getCustomer(Long id) throws Exception {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isEmpty())
            return null;
        return customer.get();
    }

    @Override
    public List<Customer> getCustomers() throws Exception {
        return customerRepository.findAll();
    }

    @Override
    public Customer updateCustomer(Customer customer) throws Exception {
        return customerRepository.save(customer);
    }
}
