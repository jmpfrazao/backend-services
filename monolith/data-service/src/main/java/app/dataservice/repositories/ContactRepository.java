package app.dataservice.repositories;

import org.springframework.data.repository.CrudRepository;

import app.dataservice.model.Contact;

public interface ContactRepository extends CrudRepository<Contact, Long>{
    
}
