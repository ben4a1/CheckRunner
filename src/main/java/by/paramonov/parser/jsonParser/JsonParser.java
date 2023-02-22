package by.paramonov.parser.jsonParser;

public interface JsonParser<T> {
    String toJson(T obj) throws ClassNotFoundException;
    T fromJson(String obj);
}
