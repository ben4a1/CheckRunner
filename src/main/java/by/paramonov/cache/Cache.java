package by.paramonov.cache;

public interface Cache<K, V> {
    void putKV(K key, V value);
    V getValue(K key);
}
