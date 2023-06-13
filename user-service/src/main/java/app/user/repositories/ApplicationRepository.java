package app.user.repositories;

import app.user.model.Application;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends MongoRepository<Application, String>{
    List<Application> findByName(String name);
}
