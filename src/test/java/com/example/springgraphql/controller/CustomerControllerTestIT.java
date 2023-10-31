package com.example.springgraphql.controller;

import com.example.springgraphql.entity.Customer;
import com.example.springgraphql.pojo.NewCustomer;
import com.example.springgraphql.repository.CustomerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.graphql.test.tester.GraphQlTester;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureGraphQlTester
class CustomerControllerTestIT {
    @Autowired
    private GraphQlTester graphQlTester;
    @Autowired
    private CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        customerRepository.deleteAll();
    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
    }

    @Test
    void getCustomerById() throws Exception {
        Customer testCustomer1 = customerRepository.save(new Customer(null, "johan", "tan", 23));
        String query = "query {\n" +
                "  getCustomerById(id: " + testCustomer1.getId() + ") {\n" +
                "    id\n" +
                "    firstname\n" +
                "    lastname\n" +
                "    age\n" +
                "  }\n" +
                "}";
        Customer customer =
                graphQlTester.document(query).execute().path("data.getCustomerById").entity(Customer.class).get();
        assertNotNull(customer);
        assertEquals(testCustomer1.getId(), customer.getId());
        assertEquals(testCustomer1.getFirstname(), customer.getFirstname());
        assertEquals(testCustomer1.getLastname(), customer.getLastname());
        assertEquals(testCustomer1.getAge(), customer.getAge());
    }

    @Test
    void getCustomers() {
        Customer testCustomer1 = customerRepository.save(new Customer(null, "johan", "tan", 23));
        Customer testCustomer2 = customerRepository.save(new Customer(null, "david", "jose", 30));
        String query = "query {\n" +
                " getAllCustomers {\n" +
                "   id,\n" +
                "  firstname,\n" +
                "  lastname,\n" +
                "  age\n" +
                " }\n" +
                "}";
        List<Customer> customers =
                graphQlTester.document(query).execute().path("data.getAllCustomers").entityList(Customer.class).get();
        assertTrue(customers.size() == 2);
        assertEquals(testCustomer1.getFirstname(), customers.get(0).getFirstname());
        assertEquals(testCustomer2.getFirstname(), customers.get(1).getFirstname());
    }

    @Test
    void newCustomer() {
        Customer testCustomer1 = new Customer(null, "johan", "tan", 23);
        String query = "mutation {\n" +
                "  newCustomer(record: {firstname: \"" + testCustomer1.getFirstname() + "\", lastname: \"" + testCustomer1.getLastname() + "\", age: " +
                "" + testCustomer1.getAge() + "}) {\n" +
                "    id\n" +
                "    firstname\n" +
                "    lastname\n" +
                "    age\n" +
                "  }\n" +
                "}";
        Customer customer =
                graphQlTester.document(query).execute().path("data.newCustomer").entity(Customer.class).get();
        assertNotNull(customer);
        assertNotNull(customer.getId());
        assertEquals(testCustomer1.getFirstname(), customer.getFirstname());
        assertEquals(testCustomer1.getLastname(), customer.getLastname());
        assertEquals(testCustomer1.getAge(), customer.getAge());
    }

    @Test
    void updateCustomer() {
        Customer testCustomer1 = customerRepository.save(new Customer(null, "johan", "tan", 23));
        NewCustomer updateTestCustomer1 = new NewCustomer(testCustomer1.getFirstname(), "sam", 24);
        String query = "mutation {\n" +
                "  updateCustomer(id:" + testCustomer1.getId() + ", record: {firstname: \"" + testCustomer1.getFirstname() + "\", " +
                "lastname: " +
                "\"" + updateTestCustomer1.getLastname() + "\", age: " +
                "" + updateTestCustomer1.getAge() + "}) {\n" +
                "    id\n" +
                "    firstname\n" +
                "    lastname\n" +
                "    age\n" +
                "  }\n" +
                "}";
        Customer customer =
                graphQlTester.document(query).execute().path("data.updateCustomer").entity(Customer.class).get();
        assertNotNull(customer);
        assertEquals(testCustomer1.getId(), customer.getId());
        assertEquals(testCustomer1.getFirstname(), customer.getFirstname());
        assertEquals(updateTestCustomer1.getLastname(), customer.getLastname());
        assertEquals(updateTestCustomer1.getAge(), customer.getAge());
    }

    @Test
    void deleteCustomer() {
        Customer testCustomer1 = customerRepository.save(new Customer(null, "johan", "tan", 23));
        String query = "mutation {\n" +
                " deleteCustomer(id: " + testCustomer1.getId() + ") {\n" +
                "   id,\n" +
                "  firstname,\n" +
                "  lastname,\n" +
                "  age\n" +
                " }\n" +
                "}";
        Customer customer =
                graphQlTester.document(query).execute().path("data.deleteCustomer").entity(Customer.class).get();
        assertNotNull(customer);
        assertNotNull(customer.getId());
        assertEquals(testCustomer1.getFirstname(), customer.getFirstname());
        assertEquals(testCustomer1.getLastname(), customer.getLastname());
        assertEquals(testCustomer1.getAge(), customer.getAge());
    }
}