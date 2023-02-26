package by.paramonov.dao;

import java.util.List;

public interface Dao<T> {
    void create(T t);
    T read(long id);
    void update(T t);
    void delete(Long id);
    List<T> getAll();
}
