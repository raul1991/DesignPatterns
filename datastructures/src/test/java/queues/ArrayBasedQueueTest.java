package queues;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.stream.IntStream;

@Ignore // to be fixed later
public class ArrayBasedQueueTest {

    private static final int TOTAL_ITEMS = 10;
    private Queue<Integer> queue = new Queue<>();

    @Before
    public void setUp() {
        Queue<Integer> integerQueue = queue;
        IntStream.range(0, TOTAL_ITEMS).forEach(integerQueue::enqueue);
    }

    @Test
    public void isEmpty() {
        Assert.assertFalse(queue.isEmpty());
    }

    @Test
    public void isFull() {
        Assert.assertTrue(queue.isFull());
    }

    @Test(expected = IllegalStateException.class)
    public void enqueue() {
        queue.enqueue(2);
    }

//    @Test
//    public void enqueueWithOverwriteFlag() {
//        queue.shouldOverwrite(true);
//        queue.enqueue(2);
//    }
//
//    @Test
//    public void enqueueAfterRemove() {
//        Assert.assertEquals(0, queue.dequeue().intValue());
//        queue.enqueue(2);
//        Assert.assertEquals(TOTAL_ITEMS, queue.size());
//    }
//
    @Test(expected = IllegalStateException.class)
    public void dequeue() {
        IntStream.rangeClosed(0, 9).forEach(i -> System.out.println(queue.dequeue()));
    }

    @Test
    public void enqueueDequeAlternating() {
        // remove all the elements.
        IntStream.range(0, TOTAL_ITEMS).forEach(i -> queue.dequeue());

        // enqueue two times more elements than we deque
        IntStream.rangeClosed(0, 9).forEach(i -> {
            if (i % 2 == 0) {
                System.out.println("De-queueing " + i);
                queue.dequeue();
            }
            else {
                System.out.println("Enqueueing " + i);
                queue.enqueue(i);
            }
        });
    }

    @Test
    public void size() {
        Assert.assertEquals(TOTAL_ITEMS, queue.size());
    }
}
