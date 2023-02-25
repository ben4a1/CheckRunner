package by.paramonov.cache.dao;

import java.util.List;

public interface Dao<T> {
    void create(T t);
    T read(long id);
    void update(T t);
    void delete(T t);
    List<T> getAll();
}
