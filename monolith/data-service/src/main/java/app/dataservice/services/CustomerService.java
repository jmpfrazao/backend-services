package app.dataservice.services;

import app.dataservice.model.Customer;

public interface CustomerService extends BaseService<Customer, Long> {
    Customer findByLastName(String lastName);
}
