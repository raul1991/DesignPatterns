package trees;

public class QueueUsingLinkedList<T>
{
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public void add(T data)
    {
        ++size;
        Node<T> tNode = new Node<>(data);
        tNode.next = null;
        // if it's the first node
        if (tail != null) tail.next = tNode;
        tail = tNode;
        if (head == null)
        {
            head = tNode; // head points to the new node
        }
    }

    public T remove()
    {
        // underflow exception must be caught as well.
        T data = head.data;
        head = head.next; // move the head to the
        if (head == null) tail = null;
        --size;
        return data;
    }

    private static class Node<T>
    {
        private Node next;
        private T data;

        public Node(T data)
        {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        QueueUsingLinkedList<Integer> queue = new QueueUsingLinkedList<>();
        queue.add(1);
        queue.add(11);
        queue.add(111);
        queue.add(1111);
        while (!queue.isEmpty())
        {
            System.out.println(queue.remove());
        }
    }

    private boolean isEmpty() {
        return size == 0;
    }
}
