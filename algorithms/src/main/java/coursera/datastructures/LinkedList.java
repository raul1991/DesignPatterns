package coursera.datastructures;

public class LinkedList<T>
{
    private Node<T> head;
    private int size;

    public int size()
    {
        return size;
    }

    public void add(T data)
    {
        Node<T> newNode = new Node<>(data);
        newNode.next = null;
        if (head == null) head = newNode;
        head.next = newNode;
        ++size;
    }

    public void delete(T data)
    {
        if (head == null) return;
        if (head.data == data) head = head.next;
        Node<T> prev = head;
        while (head.next != null)
        {
            head = head.next;
            if (head.data == data)
            {
                // node found.
                prev.next = null;
                --size;
            }
        }
    }

    private class Node<R>
    {
        private Node<R> next;
        private R data;

        public Node(R data)
        {
            this.data = data;
        }
    }

    public static void main(String[] args)
    {
        final LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(10);
        linkedList.add(12);
        linkedList.add(13);
        System.out.println(linkedList.size());
        linkedList.delete(13);
        linkedList.delete(13);
        System.out.println(linkedList.size());
    }
}
