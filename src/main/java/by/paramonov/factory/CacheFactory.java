package by.paramonov.factory;

import by.paramonov.cache.Cache;
import by.paramonov.cache.impl.LFUCache;
import by.paramonov.cache.impl.LRUCache;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//TODO cacheAlgorithm and cache size from app.yml
@Component
public class CacheFactory<K, V> {
    @Value("${custom.cache.size}")
    private int cacheSize = 4;

    public CacheFactory() {
    }

    public CacheFactory(int cacheSize) {
        this.cacheSize = cacheSize;
    }

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
