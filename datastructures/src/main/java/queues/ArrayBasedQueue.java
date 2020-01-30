package queues;

import java.util.stream.IntStream;

/**
 * Insertion happens at the write position, deletion happens at the read position.
 * Both gets incremented when any operation happens.
 *
 * @param <R>
 */
public class ArrayBasedQueue<R> {
    private boolean shouldOverwrite;
    private int write; // where insertion happens
    private int read; // where deletion happens
    private int size;
    private int maxCapacity;
    private R[] queue;

    public ArrayBasedQueue(int maxCapacity, boolean shouldOverwrite) {
        if (maxCapacity < 0) throw new IllegalStateException("Max capacity must be a positive integer less Integer.MaxValue");
        this.maxCapacity = maxCapacity;
        queue = (R[]) new Object[maxCapacity];
        this.shouldOverwrite = shouldOverwrite;
    }

    public boolean isEmpty() {
        return read == write;
    }

    public boolean isFull() {
        return size == maxCapacity;
    }

    public void enqueue(R data) {
        if (!shouldOverwrite && isFull()) throw new IllegalStateException("Queue is full");
        int index = getValidIndex(write);
        queue[index] = data;
        ++size;
        write++;
    }

    private int getValidIndex(int currIdx) {
        return currIdx < maxCapacity - 1 ? ++currIdx : 0;
    }

    public R dequeue() {
        if (!shouldOverwrite && isEmpty()) throw new IllegalStateException("Queue is empty");
        --size;
        R temp = queue[getValidIndex(read)];
        queue[getValidIndex(read)] = null;
        read++;
        return temp;
    }

    public int size() {
        return size;
    }

    public void clear() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        IntStream.range(0, size).forEach(i -> dequeue());
        read = write = 0;
    }

    public int getWritePos() {
        return write;
    }

    public int getReadPos() {
        return read;
    }

    public void shouldOverwrite(boolean shouldOverwrite) {
        this.shouldOverwrite = shouldOverwrite;
    }
}
