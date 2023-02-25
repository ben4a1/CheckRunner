package by.paramonov.factory;

import by.paramonov.cache.Cache;
import by.paramonov.cache.impl.LFUCache;
import by.paramonov.cache.impl.LRUCache;

//TODO cacheAlgorithm and cache size from app.yml
public class CacheFactory<K, V> {
    private int cacheSize = 4;

    public Cache<K, V> createCache(String cacheAlgorithm) {
        if ("lru".equalsIgnoreCase(cacheAlgorithm)) {
            return new LRUCache<>(cacheSize);
        }
        if ("lfu".equalsIgnoreCase(cacheAlgorithm)) {
            return new LFUCache<>(cacheSize);
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
