package com.home.repository;

import com.home.model.Customer;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON) // Optional as Singleton is default, Prototype is reverse
public class CustomerRepositoryImpl implements CustomerRepository {

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

        return customers;
    }
}
