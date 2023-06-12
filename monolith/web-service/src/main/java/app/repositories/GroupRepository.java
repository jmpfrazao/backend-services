package app.repositories;

import org.springframework.data.repository.CrudRepository;

import app.model.Group;

public interface GroupRepository extends CrudRepository<Group, Long> {
    
}
