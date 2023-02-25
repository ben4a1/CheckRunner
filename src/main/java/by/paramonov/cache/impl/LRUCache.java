package by.paramonov.cache.impl;

import by.paramonov.cache.Cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> extends LinkedHashMap<K, V> implements Cache<K, V> {
    private final int cacheSize;

    public LRUCache(int cacheSize) {
        super(16, 0.75f, true);
        this.cacheSize = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > cacheSize;
    }

    @Override
    public void putKV(K key, V value) {
        this.put(key, value);
    }

    @Override
    public V getValue(K key) {
        return this.get(key);
    }
}
