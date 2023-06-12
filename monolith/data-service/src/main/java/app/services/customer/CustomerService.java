package app.services.customer;

import app.model.Customer;
import app.services.common.BaseService;


public interface CustomerService extends BaseService<Customer, Long> {
    Customer findByLastName(String lastName);
}
