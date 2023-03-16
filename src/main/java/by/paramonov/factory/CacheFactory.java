package by.paramonov.factory;

import by.paramonov.cache.Cache;
import org.springframework.stereotype.Component;

@Component
public interface CacheFactory<K, V> {
    Cache<K, V> createCache();
}
