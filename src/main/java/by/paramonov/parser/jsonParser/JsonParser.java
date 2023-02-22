package by.paramonov.parser.jsonParser;

public interface JsonParser<T> {
    String toJson(T obj);
    T fromJson(String obj);
}
