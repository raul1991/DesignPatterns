package queues;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class LinkedListBasedQueueTest {

    private LinkedListBasedQueue<Integer> list = new LinkedListBasedQueue<>();
    private final int TOTAL_ITEMS = 10;

    @Before
    public void setUp() {
        if (!list.isEmpty()) list.clear();
        IntStream.rangeClosed(0, TOTAL_ITEMS).forEach(list::enqueue);
    }

    @Test
    public void enqueue() {
        Assert.assertEquals(0, list.front().intValue());
    }

    @Test
    public void isEmpty() {
        list.clear();
        Assert.assertTrue(list.isEmpty());
    }

    @Test
    public void dequeue() {
        Assert.assertEquals(0, list.dequeue().intValue());
    }

    @Test
    public void size() {
        Assert.assertEquals(TOTAL_ITEMS + 1, list.size());
    }
}