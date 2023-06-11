package app.webservice.repositories;

import org.springframework.data.repository.CrudRepository;

import app.webservice.model.Contact;

public interface ContactRepository extends CrudRepository<Contact, Long>{
    
}
