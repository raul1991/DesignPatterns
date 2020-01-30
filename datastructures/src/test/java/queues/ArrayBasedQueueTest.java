package queues;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

public class ArrayBasedQueueTest {

    private static final int TOTAL_ITEMS = 10;
    private ArrayBasedQueue<Integer> queue = new ArrayBasedQueue<>(TOTAL_ITEMS, false);

    @Before
    public void setUp() {
        if (!queue.isEmpty()) queue.clear();
        queue.shouldOverwrite(false);
        IntStream.range(0, TOTAL_ITEMS).forEach(queue::enqueue);
    }

    @Test
    public void isEmpty() {
        Assert.assertFalse(queue.isEmpty());
        queue.clear();
        Assert.assertTrue(queue.isEmpty());
        Assert.assertEquals(queue.getReadPos(), queue.getWritePos());
    }

    @Test
    public void isFull() {
        Assert.assertTrue(queue.isFull());
        queue.clear();
        Assert.assertTrue(queue.isEmpty());
    }

    @Test(expected = IllegalStateException.class)
    public void enqueue() {
        queue.enqueue(2);
    }

    @Test
    public void enqueueWithOverwriteFlag() {
        queue.shouldOverwrite(true);
        queue.enqueue(2);
    }

    @Test
    public void enqueueAfterRemove() {
        Assert.assertEquals(0, queue.dequeue().intValue());
        queue.enqueue(2);
        Assert.assertEquals(TOTAL_ITEMS, queue.size());
    }

    @Test(expected = IllegalStateException.class)
    public void dequeue() {
        queue.clear();
        queue.dequeue();
    }

    @Test
    public void dequeueValidCase() {
        Integer data = queue.dequeue();
        Assert.assertEquals(0, data.intValue());
    }

    @Test
    public void size() {
        Assert.assertEquals(TOTAL_ITEMS, queue.size());
    }
}