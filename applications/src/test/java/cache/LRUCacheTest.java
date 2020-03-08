package cache;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LRUCacheTest {

    private LRUCache<Integer, Integer> cache = new LRUCache<>(5);
    private static final int TOTAL_CAPACITY = 5;

    @Before
    public void setUp() {
        IntStream.rangeClosed(1, TOTAL_CAPACITY).forEach(i -> cache.put(i, i));
    }

    @Test
    public void get() {
        // ensure every item is present
        IntStream.rangeClosed(1, TOTAL_CAPACITY).forEach(i -> assertTrue(cache.exists(i)));
    }

    @Test
    public void getAndExpectItToBeTheFirstItem()
    {
        // accessing the first item removes it from its position, adds it to the the front (head).
        cache.get(1);
        assertEquals(2, cache.getLRUItem().get().intValue());
        assertEquals(1, cache.getMRUItem().get().intValue());
    }

    @Test
    public void getMiddleItemAndExpectItToBeTheFirstItem()
    {
        // accessing the first item removes it from its position, adds it to the the front (head).
        int key = TOTAL_CAPACITY / 2;
        cache.get(key);
        assertEquals(key, cache.getMRUItem().get().intValue());
        assertEquals(1, cache.getLRUItem().get().intValue());
    }

    @Test
    public void getInvalidKey()
    {
        assertEquals(1, cache.getLRUItem().get().intValue());
        assertEquals(5, cache.getMRUItem().get().intValue());
        assertEquals(Optional.empty(), cache.get(-1));
        // make sure everything stays the same.
        assertEquals(1, cache.getLRUItem().get().intValue());
        assertEquals(5, cache.getMRUItem().get().intValue());
    }

    @Test
    public void performRandomOperations() {
        IntStream.range(0, 1000).forEach(value -> {
            cache.get(value % TOTAL_CAPACITY);
            cache.put(value, value);
        });
        Assert.assertEquals(TOTAL_CAPACITY, cache.size());
    }

    @Test
    public void size() {
    }
}