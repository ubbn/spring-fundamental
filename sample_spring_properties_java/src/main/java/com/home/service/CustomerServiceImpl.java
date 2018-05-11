package com.home.service;

import com.home.model.Customer;
import com.home.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll()
                .stream().filter(x -> x.getLastName() != null)
                .collect(Collectors.toList());
    }
}
