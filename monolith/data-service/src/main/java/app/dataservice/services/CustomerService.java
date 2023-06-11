package app.dataservice.services;

import java.util.Set;

import app.dataservice.model.Customer;

public interface CustomerService {
    Customer findByLastName(String lastName);

    Customer findById(Long id);

    Customer save(Customer customer);

    Set<Customer> findAll();
}
