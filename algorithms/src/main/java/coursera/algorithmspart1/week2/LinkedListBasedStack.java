package coursera.algorithmspart1.week2;

public class LinkedListBasedStack
{
    private int size; // stores the total count for the data nodes
    private Node node; // stores the ref to the last node added

    public String pop() throws Exception
    {
        if (size == 0) throw new Exception("Stack underflow");
        String data = node.data;
        node = node.next; // point last node to the next node.
        --size;
        System.out.println("Popped : " + data);
        return data;
    }

    public void push(String data)
    {
        Node oldFirst = node;
        node = new Node();
        node.next = oldFirst;
        node.data = data;
        ++size;
        System.out.println("Pushed : " + data);
    }

    public int size()
    {
        System.out.println("Size : " + size);
        return size;
    }

    private class Node
    {
        private String data;
        private Node next;

        @Override
        public String toString()
        {
            return String.format("{data: %s, isLast: %s}", data, next == null);
        }
    }

    public static void main(String[] args) throws Exception
    {
        LinkedListBasedStack linkedStack = new LinkedListBasedStack();
        linkedStack.push("5");
        linkedStack.push("4");
        linkedStack.push("3");
        linkedStack.size();
        linkedStack.pop();
        linkedStack.size();
        linkedStack.pop();
        linkedStack.size();
        linkedStack.pop();
        linkedStack.size();
    }
}
