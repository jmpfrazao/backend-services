package app.user.repositories;

import app.user.model.Release;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReleaseRepository extends MongoRepository<Release, String>{
}
