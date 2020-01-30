package queues;

public class LinkedListBasedQueue<R> {
    private Node<R> front;
    private Node<R> rear;
    private int size;

    /**
     * Adds an item at the rear.
     * @param data the item to be added
     */
    public void enqueue(R data) {
        Node<R> newNode = new Node<>(data);
        newNode.data = data;
        newNode.next = null;
        if (isEmpty()) {
            front = rear = newNode;
        }
        else {
            rear.next = newNode;
            rear = newNode;
        }
        ++size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Removes from the front.
     * @return R the item removed
     */
    public R dequeue() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty already.");
        R data = front.data;
        front = front.next;
        --size;
        return data;
    }

    public int size() {
        return size;
    }

    public R front() {
        return front.data;
    }

    public void clear() {
        if (isEmpty()) throw new IllegalStateException("Empty queue exception");
        int pos = -1;
        Node<R> ptr = front;
        while (++pos < size) {
            ptr = ptr.next;
            front.data = null;
            front.next = null;
            front = ptr;
        }
        size = 0;
    }

    private class Node<E> {
        private R data;
        private Node<E> next;

        private Node(R data) {
            this.data = data;
        }
    }
}
