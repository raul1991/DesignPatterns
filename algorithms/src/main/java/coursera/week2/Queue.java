package coursera.week2;

public class Queue
{
    private int size;
    private int cap;
    private String[] items;

    public Queue(int cap)
    {
        this.cap = cap;
        items = new String[cap];
    }

    public String dequeue()
    {
        size--;
        return items[0];
    }

    public void enqueue(String item)
    {
        items[size++] = item;
    }

    public int size()
    {
        return size;
    }

    public static void main(String[] args)
    {
        Queue queue = new Queue(10);
        System.out.println("Size: "+ queue.size());
        queue.enqueue("to");
        queue.enqueue("be");
        queue.enqueue("or");
        queue.enqueue("not");
        queue.enqueue("to");
        queue.enqueue("be");
        System.out.println("Size :" + queue.size());
        System.out.println("Dequeue :" + queue.dequeue());
    }
}
