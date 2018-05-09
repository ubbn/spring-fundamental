package com.home;

import com.home.service.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        // CustomerService customerService = new CustomerServiceImpl();

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CustomerService customerService = context.getBean("fooCustomerService", CustomerService.class);

        System.out.println(customerService.findAll().get(0).getFirstName());
    }
}
