package by.paramonov.factory.impl;

import by.paramonov.cache.Cache;
import by.paramonov.cache.impl.LFUCache;
import by.paramonov.factory.CacheFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class CacheFactoryLFU<K, V> implements CacheFactory<K, V> {
    @Value("${cache.size}")
    int cacheSize;

    @Override
    public Cache<K, V> createCache() {
        return new LFUCache<>(cacheSize);
    }
}
