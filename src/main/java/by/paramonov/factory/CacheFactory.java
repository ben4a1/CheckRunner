package by.paramonov.factory;

import by.paramonov.cache.impl.LRUCache;

public class CacheFactory<K, V> {
    private int cacheSize = 4;

    public LRUCache<K, V> createCache(String cacheAlgorithm) {
        if ("lru".equalsIgnoreCase(cacheAlgorithm)) {
            return new LRUCache<>(cacheSize);
        }
        return null;
    }

    public int getCacheSize() {
        return cacheSize;
    }

    public void setCacheSize(int cacheSize) {
        this.cacheSize = cacheSize;
    }
}
