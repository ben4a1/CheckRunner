package by.paramonov.factory.impl;

import by.paramonov.cache.Cache;
import by.paramonov.cache.impl.LRUCache;
import by.paramonov.factory.CacheFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CacheFactoryLRU<K, V> implements CacheFactory<K, V> {

    @Value("${cache.size}")
    int cacheSize;

    @Override
    public Cache<K, V> createCache() {
        return new LRUCache<>(cacheSize);
    }
}
