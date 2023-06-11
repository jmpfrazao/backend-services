package app.webservice.repositories;

import org.springframework.data.repository.CrudRepository;

import app.webservice.model.Group;

public interface GroupRepository extends CrudRepository<Group, Long> {
    
}
