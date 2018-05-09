package com.home.repository;

import com.home.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("fooCustomerRepository")
public class CustomerRepositoryImpl implements CustomerRepository {

    @Override
    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();

        Customer customerA = new Customer();
        customerA.setFirstName("Chibarushka");
        customerA.setLastName("Babushka");
        customers.add(customerA);

        Customer customerB = new Customer();
        customerB.setFirstName(null);
        customerB.setLastName("Gena");
        customers.add(customerB);

        return customers;
    }

}
