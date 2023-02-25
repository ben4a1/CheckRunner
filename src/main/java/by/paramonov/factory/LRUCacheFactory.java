package by.paramonov.factory;

import by.paramonov.cache.Cache;
import by.paramonov.cache.impl.LRUCache;

public class LRUCacheFactory<K, V> extends CacheFactory<K, V> {
    private int cacheSize = 4;

    @Override
    public Cache<K, V> createCache() {
        return new LRUCache<>(cacheSize);
    }
    public int getCacheSize() {
        return cacheSize;
    }

    public void setCacheSize(int cacheSize) {
        this.cacheSize = cacheSize;
    }
}
