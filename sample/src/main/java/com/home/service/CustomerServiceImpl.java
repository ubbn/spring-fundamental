package com.home.service;

import com.home.model.Customer;
import com.home.repository.CustomerRepository;
import com.home.repository.CustomerRepositoryImpl;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerServiceImpl implements CustomerService {

    CustomerRepository customerRepository = new CustomerRepositoryImpl();

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll()
                .stream().filter(x -> x.getLastName() != null)
                .collect(Collectors.toList());
    }
}
