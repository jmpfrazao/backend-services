package app.webservice.repositories;

import org.springframework.data.repository.CrudRepository;

import app.webservice.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
    
}
