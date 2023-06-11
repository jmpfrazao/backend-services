package app.dataservice.repositories;

import org.springframework.data.repository.CrudRepository;

import app.dataservice.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
    
}
