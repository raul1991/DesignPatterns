package queues;

/**
 * The abstract data type that must support the following operations
 *
 * - enqueue
 * - size
 * - isEmpty
 * - dequeue
 *
 * [- 0 0 0 0 0 0]
 *              ^^
 */
public class Queue<R> {
    private final int capacity;
    private R[] elements;
    private int size;
    private int front;
    private int back;

    public Queue() {
        this.capacity = 10;
        elements = (R[]) new Object[this.capacity];
    }

    public Queue(int capacity) {
        this.capacity = Math.max(10, capacity);
    }

    // insertion happens at the back
    public void enqueue(R data) {
        if (isFull()) throw new IllegalStateException("Queue is full");
        elements[++back] = data;
        ++size;
    }

    public R dequeue() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        System.out.println("front =" + front + " back = " + back);
        --size;
        return elements[++front];
    }

    public boolean isEmpty() {
        return front == back;
    }

    public boolean isFull() {
        return back == elements.length;
    }

    public int size() {
        return size;
    }
}
