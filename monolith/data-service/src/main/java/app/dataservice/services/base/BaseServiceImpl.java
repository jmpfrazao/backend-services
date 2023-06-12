package app.dataservice.services.base;

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
