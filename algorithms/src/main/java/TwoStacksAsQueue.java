import java.util.Stack;

public class TwoStacksAsQueue<T>
{
    private Stack<T> oldestOnTop;
    private Stack<T> newestOnTop;

    public static void main(String[] args)
    {
        final TwoStacksAsQueue<Object> queue = new TwoStacksAsQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.dequeue());
    }

    public void shiftElements()
    {
        if (oldestOnTop.isEmpty())
        {
            while (!newestOnTop.isEmpty())
            {
                oldestOnTop.push(newestOnTop.pop());
            }
        }
    }

    public TwoStacksAsQueue()
    {
        this.oldestOnTop = new Stack<>();
        this.newestOnTop = new Stack<>();
    }

    /**
     * Pushes the item to the top.
     * @param item
     */
    public void enqueue(T item)
    {
        newestOnTop.push(item);
    }

    /**
     * gets the oldest item
     * @return
     */
    public T peek()
    {
        shiftElements();
        return oldestOnTop.peek();
    }

    public T dequeue()
    {
        shiftElements();
        return oldestOnTop.pop();
    }
}
