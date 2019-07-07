public class LoopInALinkedList
{

    public boolean hasCycle(Node head)
    {
        if (head == null) return false;
        Node fast = head.next;
        Node slow = head;
        while (fast != null && fast.next != null && slow !=null)
        {
            if (slow == fast) return true;
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }

    private static class Node<T>
    {
        private Node<T> next;
        private T data;
    }
}
