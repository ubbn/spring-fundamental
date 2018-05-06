package com.home.service;

import com.home.model.Customer;
import com.home.repository.CustomerRepository;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    public CustomerServiceImpl(){
        System.out.println("default constructor invoked");
    }

    // Constructor injection
    // CustomerRepository at index 0 in parameter list
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        System.out.println("injected through Constructor");
        this.customerRepository = customerRepository;
    }

    // Setter injection
    public void setCustomerRepository(CustomerRepository customerRepository) {
        System.out.println("injected through Setter");
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll()
            .stream().filter(x -> x.getFirstName() != null || x.getLastName() != null)
            .collect(Collectors.toList());
    }

}
