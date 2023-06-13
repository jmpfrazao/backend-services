package app.services.common;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class BaseServiceImpl<T, ID> {
    protected Map<ID, T> map = new HashMap<>();

    public Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    public  T findById(ID id) {
        return map.get(id);
    }

    // for mongo https://github.com/springframeworkguru/spring5-mongo-recipe-app/tree/integration-testing-mongodb

    // https://www.udemy.com/course/spring-framework-5-beginner-to-guru/learn/lecture/11235012#overview
    // for id increment
    public  T save(ID id, T object) {
        map.put(id, object);
        return object;
    }

    public  void deleteById(ID id) {
        map.remove(id);
    }

    // void delete(T object) {
    //     map.entrySet().remove(entry -> entry.getValue().equals(object));
    // }
}
