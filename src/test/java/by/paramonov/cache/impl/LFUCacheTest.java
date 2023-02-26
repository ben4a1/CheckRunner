package by.paramonov.cache.impl;

import by.paramonov.cache.Cache;
import by.paramonov.factory.CacheFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.assertj.core.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LFUCacheTest {
    private CacheFactory<String, Integer> cacheFactory;
    private Cache<String, Integer> lfuCache;
    @BeforeAll
    void prepare(){
        cacheFactory = new CacheFactory<>();
        lfuCache = cacheFactory.createCache("LFU");
        lfuCache.put("one", 1);
        lfuCache.put("two", 2);
        lfuCache.get("one");
        lfuCache.put("three", 3);
        lfuCache.put("four", 4);
        lfuCache.put("five", 5);
    }

    @Test
    void checkGetShouldReturn1() {
        assertThat(lfuCache.get("one")).isEqualTo(1);
    }
    @Test
    void checkGetShouldReturnNull() {
        assertThat(lfuCache.get("two")).isNull();
    }

    /**
     * Check that adding a new element does not increase the allowed cache size
     */
    @Test
    void checkGetAllShouldReturnEquals() {
        lfuCache.put("eleven", 11);
        assertThat(lfuCache.getAll().size()).isEqualTo(4);
    }
}