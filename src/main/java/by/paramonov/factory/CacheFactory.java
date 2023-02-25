package by.paramonov.factory;

import by.paramonov.cache.Cache;

public abstract class CacheFactory<K, V> {
    public abstract Cache<K, V> createCache();
}
