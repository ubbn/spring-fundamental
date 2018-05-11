package com.home.repository;

import com.home.model.Customer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    @Value("${dbUsername}")
    private String dbUsername;

    @Value("${dbPassword}")
    private String dbPassword;

    @Override
    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();

        Customer customerA = new Customer();
        customerA.setFirstname("Chibarushka");
        customerA.setLastName("Babushka");
        customers.add(customerA);

        Customer customerB = new Customer();
        customerB.setFirstname(null);
        customerB.setLastName("Gena");
        customers.add(customerB);

        System.out.println("Db username: " + dbUsername);
        System.out.println("Db password: " + dbPassword);

        return customers;
    }
}
