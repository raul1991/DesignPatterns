package coursera.week2;

import java.util.Arrays;

public class ArrayStack
{
    private int size; //push pop happens here
    private int capacity; //push pop happens here
    private String[] strings; // data

    public ArrayStack(int cap)
    {
        this.capacity = cap;
        this.strings = new String[capacity];
    }

    private void ensureCapacity(int currSize)
    {
        if (currSize == capacity)
        {
            int newCapacity = capacity * 2;
            growStack(newCapacity);
            this.capacity = newCapacity;
        }
    }

    private void growStack(int capacity)
    {
        System.out.println("Expanding...");
        strings = Arrays.copyOf(strings, capacity, String[].class);
    }

    public void push(String data)
    {
        ensureCapacity(size);
        strings[size++] = data;
    }

    public String pop() throws Exception
    {
        if (size == 0) throw new Exception("Stack underflow");
        String data = strings[size - 1];
        strings[size] = null;
        size--;
        return data;
    }

    public int size()
    {
        return size;
    }

    public static void main(String[] args) throws Exception
    {
        ArrayStack stack = new ArrayStack(10);
        stack.push("5");
        stack.push("4");
        stack.push("3");
        System.out.println(stack.size());
        System.out.println("Popped : " + stack.pop());
        System.out.println("Popped : " + stack.pop());
        System.out.println("Popped : " + stack.pop());
        System.out.println(stack.size());
    }
}
