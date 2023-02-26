package by.paramonov.cache;

import by.paramonov.factory.CacheFactory;
import org.assertj.core.api.Assertions;
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
    }

    @Test
    void checkPutShouldReturnEquals() {
        lfuCache.put("one", 1);
        lfuCache.put("two", 2);
        lfuCache.get("one");
        lfuCache.put("three", 3);
        lfuCache.put("four", 4);
        lfuCache.put("five", 5);
        assertThat(lfuCache.get("one")).isEqualTo(1);
    }

    @Test
    void get() {
    }

    @Test
    void getAll() {
    }
}