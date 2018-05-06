package com.home.service;

import com.home.model.Customer;
import com.home.repository.CustomerRepository;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll()
                .stream().filter(x -> x.getLastName() != null)
                .collect(Collectors.toList());
    }
}
