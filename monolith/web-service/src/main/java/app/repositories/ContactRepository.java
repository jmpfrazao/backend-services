package app.repositories;

import org.springframework.data.repository.CrudRepository;

import app.model.Contact;

public interface ContactRepository extends CrudRepository<Contact, Long>{
    
}
