package by.paramonov.cache;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public interface Cache<K, V> {
    void put(K key, V value);
    V get(K key);
    Map<K, V> getAll();
}
