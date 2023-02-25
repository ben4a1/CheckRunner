package by.paramonov.cache.impl;

import by.paramonov.cache.Cache;
import by.paramonov.factory.CacheFactory;

import java.util.LinkedHashMap;
import java.util.Map;


public class LRUCache<K, V> implements Cache<K, V> {
    int cacheSize;
    Map<K, V> cacheData;
    public LRUCache(int cacheSize) {
        cacheData = new LinkedHashMap<>(cacheSize) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > cacheSize;
            }
        };
        this.cacheSize = cacheSize;
    }

    @Override
    public void put(K key, V value) {
        cacheData.put(key, value);
    }

    @Override
    public V get(K key) {
        if (!cacheData.containsKey(key)) {
            return null;
        }
        V value = cacheData.get(key);
        cacheData.remove(key);
        cacheData.put(key, value);
        return value;
    }

    @Override
    public Map<K,V> getAll() {
        return cacheData;
    }

    public static void main(String[] args) {
        CacheFactory<Integer, Integer> integerIntegerLRUCacheFactory = new CacheFactory<>();
        Cache<Integer, Integer> cache = integerIntegerLRUCacheFactory.createCache("lrU");
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);
        cache.get(1);
        cache.put(5, 5);
        cache.put(6, 6);
        cache.put(7, 7);
        System.out.println(cache.getAll());
    }
}
