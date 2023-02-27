package by.paramonov.config;

import by.paramonov.factory.CacheFactory;
import by.paramonov.factory.impl.CacheFactoryLFU;
import by.paramonov.factory.impl.CacheFactoryLRU;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheFactoryConfig<K, V> {
    @Bean(name = "lruCache")
    @ConditionalOnProperty(prefix = "cache", name = "algorithm", havingValue = "lru")
    public CacheFactory<K, V> cacheFactoryLRU() {
        return new CacheFactoryLRU<>();
    }

    @Bean(name = "lfuCache")
    @ConditionalOnProperty(prefix = "cache", name = "algorithm", havingValue = "lfu")
    public CacheFactory<K, V> cacheFactoryLFU() {
        return new CacheFactoryLFU<>();
    }
}
