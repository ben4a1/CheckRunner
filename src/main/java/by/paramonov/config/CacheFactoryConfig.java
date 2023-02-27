package by.paramonov.config;

import by.paramonov.factory.CacheFactory;
import by.paramonov.factory.impl.CacheFactoryLFU;
import by.paramonov.factory.impl.CacheFactoryLRU;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheFactoryConfig {
    @Bean(name = "lruCache")
    @ConditionalOnProperty(prefix = "cache", name = "algorithm", havingValue = "lru")
    public CacheFactory cacheFactoryLRU() {
        return new CacheFactoryLRU();
    }

    @Bean(name = "lfuCache")
    @ConditionalOnProperty(prefix = "cache", name = "algorithm", havingValue = "lfu")
    public CacheFactory cacheFactoryLFU() {
        return new CacheFactoryLFU();
    }
}
