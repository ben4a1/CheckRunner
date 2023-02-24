package by.paramonov.parser.jsonParser;

import java.io.File;

public interface JsonParser<T> {
    String toJson(T obj) throws ClassNotFoundException;
    T fromJson(File obj);
}
