package app.dataservice.services.customer;

import app.dataservice.model.Customer;
import app.dataservice.services.base.BaseService;

public interface CustomerService extends BaseService<Customer, Long> {
    Customer findByLastName(String lastName);
}
