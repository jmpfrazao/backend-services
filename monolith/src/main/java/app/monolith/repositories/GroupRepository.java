package app.monolith.repositories;

import org.springframework.data.repository.CrudRepository;

import app.monolith.model.Group;

public interface GroupRepository extends CrudRepository<Group, Long> {
    
}
