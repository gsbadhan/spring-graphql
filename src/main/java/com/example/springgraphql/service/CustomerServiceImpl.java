package com.example.springgraphql.service;

import com.example.springgraphql.entity.Customer;
import com.example.springgraphql.pojo.NewCustomer;
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
    public Customer updateCustomer(Long id, NewCustomer newCustomer) throws Exception {
        Customer customer = customerRepository.findById(id).get();
        customer.setFirstname(newCustomer.getFirstname());
        customer.setLastname(newCustomer.getLastname());
        customer.setAge(newCustomer.getAge());
        return customerRepository.save(customer);
    }

    @Override
    public Customer deleteCustomer(Long id) throws Exception {
        Customer customer = customerRepository.findById(id).get();
        customerRepository.deleteById(id);
        return customer;
    }

    @Override
    public Customer newCustomer(NewCustomer newCustomer) throws Exception {
        Customer customer = customerRepository.save(new Customer(null, newCustomer.getFirstname(),
                newCustomer.getLastname(),
                newCustomer.getAge()));
        return customer;
    }
}
