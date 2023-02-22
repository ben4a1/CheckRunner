package by.paramonov.mapper;

public interface JsonMapper<T> {
    String toJson(T obj);
    T fromJson(String obj);
}
