package app.dataservice.repositories;

import org.springframework.data.repository.CrudRepository;

import app.dataservice.model.Group;

public interface GroupRepository extends CrudRepository<Group, Long> {
    
}
