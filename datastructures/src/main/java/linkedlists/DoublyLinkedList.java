package linkedlists;

import java.util.LinkedList;

public class DoublyLinkedList<R> {
    private Node<R> head; // points to the head node where insertions happen.
    private Node<R> tail; // points to the back of the node.
    private int size;

    public Node<R> add(R data) {
        Node<R> newNode = new Node<>(data);

        if (head == null) {
            // first insertion
            head = newNode;
            tail = newNode;
            newNode.next = null;
            newNode.prev = null;
        }
        else {
            // relocate existing nodes
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        ++size;
        return newNode;
    }

    public void add(R data, int index) {
        rangeCheck(index);
        int pos = -1;
        Node<R> ptr = head;
        Node<R> newNode = new Node<>(data);
        while (++pos < index - 1) {
            ptr = ptr.next;
        }
        // link the new node with previous node
        newNode.prev = ptr;
        newNode.next = ptr.next;
        // link the old next node with the new node
        ptr.next.prev = newNode;
        ptr.next = newNode;
        // increment the size.
        ++size;
    }

    public R get(int index) {
        rangeCheck(index);
        int pos = -1;
        Node<R> ptr = head;
        while (++pos < index) {
            ptr = ptr.next;
        }
        // now pointer is at the node we wanted.
        return ptr.data;
    }

    private void rangeCheck(int index) {
        if (index < 0 || index > size - 1) throw new IndexOutOfBoundsException(
                "Index should be in the range (0-" + (size - 1) + ")");
    }

    public void clear() {
        checkEmpty();
        int pos = -1;
        Node<R> ptr = head;
        while (++pos < size) {
            ptr = ptr.next;
            head.data = null;
            head.prev = null;
            head.next = null;
        }
        head = tail = null;
        size = 0;
    }

    private void checkEmpty() {
        if (size == 0) throw new IllegalStateException("List empty");
    }

    public void remove(int index) {
        checkEmpty();
        rangeCheck(index);
        int pos = -1;
        Node<R> ptr = head;
        while (++pos < index) {
            ptr = ptr.next;
        }
        ptr.prev.next = ptr.next;
        ptr.next.prev = ptr.prev;
        --size;
    }

    /**
     * Removes from the tail
     */
    public void remove() {
        checkEmpty();
        if (size == 1)
        {
            // just one node
            head = tail = null;
        }
        else
        {
            // move tail to the next node
            tail = tail.prev;
            tail.next = null;
        }
        --size;
    }

    public int size() {
        return size;
    }

    private class Node<E> {
        private Node<E> prev; // represents the back
        private Node<E> next; // represents the next
        private E data;

        private Node(E data) {
            this.data = data;
        }
    }
}
