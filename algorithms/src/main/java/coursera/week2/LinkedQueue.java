package coursera.week2;

public class LinkedQueue
{
    private Node first; // points to where the next insertion happens
    private Node last;
    private int size; // the size of this queue

    public void enqueue(String data)
    {
        Node oldLast = last;
        last = new Node();
        last.next = null;
        last.data = data;
        if (size == 0) first = last;
        else oldLast.next = last;
        size++;
    }

    public String dequeue() throws Exception
    {
        if (size == 0) throw new Exception("Empty queue");
        String oldFirst = first.data;
        first = first.next;
        size--;
        return oldFirst;
    }

    public int size()
    {
        return size;
    }

    private class Node
    {
        private Node next;
        private String data;
    }

    public static void main(String[] args) throws Exception
    {
        LinkedQueue queue = new LinkedQueue();
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        System.out.println(queue.dequeue().equals("1"));
        System.out.println(queue.dequeue().equals("2"));
        System.out.println(queue.dequeue().equals("3"));
        System.out.println(queue.size() == 0);


    }
}
