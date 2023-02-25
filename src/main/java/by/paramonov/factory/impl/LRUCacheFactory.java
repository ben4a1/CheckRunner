package by.paramonov.factory.impl;

import by.paramonov.cache.Cache;
import by.paramonov.cache.impl.LRUCache;
import by.paramonov.factory.CacheFactory;

public class LRUCacheFactory<K, V> extends CacheFactory<K, V> {
    private int cacheSize = 3;

    @Override
    public Cache<K, V> createCache() {
        return new LRUCache<K, V>(cacheSize);
    }
    public int getCacheSize() {
        return cacheSize;
    }

    public void setCacheSize(int cacheSize) {
        this.cacheSize = cacheSize;
    }
}
