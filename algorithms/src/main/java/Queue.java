public class Queue<T>
{
    private Node<T> head;
    private Node<T> tail;

    public void add(T data)
    {
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
}
