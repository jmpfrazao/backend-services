package app.monolith.repositories;

import org.springframework.data.repository.CrudRepository;

import app.monolith.model.Contact;

public interface ContactRepository extends CrudRepository<Contact, Long>{
    
}
