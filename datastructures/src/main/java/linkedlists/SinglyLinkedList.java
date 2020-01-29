package linkedlists;

public class SinglyLinkedList<R> {
    private int size; // total items inside
    private Node<R> head; // points to the latest node

    public int size() {
        return size;
    }

    private Node<R> getItemAt(int pos) {
        rangeCheck(pos);
        // use temp pointer to move forward.
        Node<R> temp = head;
        int counter = -1;
        while (++counter < pos) {
            temp = temp.next;
        }
        return temp;
    }

    public R get(int pos) {
        Node<R> itemAt = getItemAt(pos);
        return itemAt != null ? itemAt.data : null;
    }

    private void rangeCheck(int pos) {
        if (pos < 0 || pos > size - 1)
            throw new IndexOutOfBoundsException("Index out of range, valid indexes from 0 - " + (size - 1));
    }

    public void add(R item) {
        // create a new node for it.
        Node<R> newNode = new Node<>(item);
        newNode.next = head;
        // move head to this node
        head = newNode;
        // increase the size
        ++size;
    }

    /**
     * Adds item at a specific position. This position can be
     * 1. at the start (head)
     * 2. at the end (iterate there and then add)
     * 3. or in the middle of the list. Requires interchanging the pointers.
     * @param item thing to add
     * @param pos the position to add the 'thing' at.
     */
    public void add(R item, int pos) {
        if (pos == 0) {
            // normal insertion at the beginning
            add(item);
            return;
        }
        Node<R> prev = getItemAt(pos);
        // create a new node to add
        Node<R> newNode = new Node<>(item);
        newNode.next = prev.next;
        // point prev node's next to the new node
        prev.next = newNode;
    }

    public void append(R item) {
        // create new node
        Node<R> newNode = new Node<>(item);
        newNode.next = null;
        while (head.next != null) {
            head = head.next;
        }
        head.next = newNode;
        ++size;
    }

    public void remove(R item) {
        // if the first node matches it.
        if (size == 0) throw new IllegalStateException("Empty list exception");
        else if (head.data == item) {
            head = head.next;
            --size;
        }
        else {
            // find a node before this item
            Node<R> prev = head; // storing the prev node
            Node<R> next = head;
            for (int i = 1; i < size; i++) {
                if (next == null) throw new IllegalArgumentException(String.format("Item : %s does not exists", item));
                else if (next.data == item) {
                    // item found
                    prev.next = next.next;
                    --size;
                    return;
                }
                prev = next;
                next = next.next;
            }

        }
    }

    public int indexOf(R item) {
        int pos = 0;
        for (Node<R> prev = head; prev != null;) {
            if (prev.data == item) {
                return pos;
            }
            prev = prev.next;
            ++pos;
        }
        return -1;
    }

    public void clear() {
        if (head == null) return;
        for (Node<R> prev = head; prev != null;) {
            Node<R> next = prev.next;
            prev.next = null;
            prev.data = null;
            prev = next;
            --size;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data) {
            this.data = data;
        }
    }
}
