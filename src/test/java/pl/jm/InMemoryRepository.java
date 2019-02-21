package pl.jm;

import lombok.SneakyThrows;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryRepository<T, ID extends Serializable> implements CrudRepository<T, ID> {

    protected Map<ID, T> database = new HashMap<>();

    @Override
    public <S extends T> S save(S entity) {

        final ID id = (ID) getId(entity);

        if (findById(id).isPresent()) {
            throw new IllegalStateException("inserting duplicating entry with id: " + id);
        }

        database.put(id, entity);
        return entity;
    }

    @Override
    public Iterable<T> findAll() {
        return database.values();
    }

    @Override
    public Optional<T> findById(ID id) {
        return Optional.ofNullable(database.get(id));
    }

    @Override
    public <S extends T> Iterable<S> saveAll(Iterable<S> entities) {
        throw new RuntimeException("Not Implemented");
    }

    @Override
    public boolean existsById(ID id) {
        throw new RuntimeException("Not Implemented");
    }

    @Override
    public Iterable<T> findAllById(Iterable<ID> ids) {
        throw new RuntimeException("Not Implemented");
    }

    @Override
    public long count() {
        throw new RuntimeException("Not Implemented");
    }

    @Override
    public void deleteById(ID id) {
        throw new RuntimeException("Not Implemented");
    }

    @Override
    public void delete(T entity) {
        throw new RuntimeException("Not Implemented");
    }

    @Override
    public void deleteAll(Iterable<? extends T> entities) {
        throw new RuntimeException("Not Implemented");
    }

    @Override
    public void deleteAll() {
        throw new RuntimeException("Not Implemented");
    }

    @SneakyThrows
    private static Object getId(Object t) {
        return MethodUtils.invokeMethod(t, "getId");
    }
}
