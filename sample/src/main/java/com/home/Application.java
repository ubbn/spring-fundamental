package com.home;

import com.home.service.CustomerService;
import com.home.service.CustomerServiceImpl;

public class Application {
    public static void main(String[] args) {
        CustomerService customerService = new CustomerServiceImpl();
        System.out.println(customerService.findAll().get(0).getFirstname());
    }
}
