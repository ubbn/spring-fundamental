package com.home.repository;

import com.home.model.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();
}
