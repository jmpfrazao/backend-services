package app.dataservice.services.customer;

import java.util.Set;

import app.dataservice.model.Customer;
import app.dataservice.services.base.BaseService;
import app.dataservice.services.base.BaseServiceImpl;


public class CustomerServiceImpl extends BaseServiceImpl<Customer, Long> implements BaseService<Customer, Long> {
    @Override
    public Set<Customer> findAll() {
        return super.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Customer save(Customer object) {
        return super.save(object.getId(), object);
    }
    
    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
