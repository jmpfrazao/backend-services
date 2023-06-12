package app.services.customer;

import java.util.Set;

import org.springframework.stereotype.Service;

import app.model.Customer;
import app.services.common.BaseServiceImpl;



@Service
public class CustomerServiceImpl extends BaseServiceImpl<Customer, Long> implements CustomerService{
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

    @Override
    public Customer findByLastName(String lastName) {
        return null;
    }

    
}
