package app.monolith.repositories;

import org.springframework.data.repository.CrudRepository;

import app.monolith.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
    
}
