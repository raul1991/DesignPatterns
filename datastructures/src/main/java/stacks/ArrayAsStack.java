package stacks;

import java.util.stream.IntStream;

public class ArrayAsStack<R> {
    private R[] stack;
    private int capacity;
    private int top; // where insertion happens
    private int size; // total items in stack
    static final int MAX_CAPACITY = 10;

    // initialize
    public ArrayAsStack(int capacity) {
        this.stack = (R[]) new Object[capacity];
        this.capacity = Math.min(capacity, MAX_CAPACITY);
        this.top = -1;
    }

    // exception checks
    private void checkForUnderflow() {
        if (top == -1) throw new ArrayIndexOutOfBoundsException("Stack empty");
    }

    private void checkForOverflow() {
        if (top == size) throw new ArrayIndexOutOfBoundsException("Stack max capacity reached.");
    }

    // methods
    public boolean isEmpty() {
        return size == 0;
    }

    public R push(R item) {
        checkForOverflow();
        stack[++top] = item;
        ++size;
        return item;
    }

    public R pop() {
        checkForUnderflow();
        R value = stack[top];
        stack[top--] = null;
        --size;
        return value;
    }

    public void clear() {
        IntStream.range(0, size).forEach(value -> this.pop());
    }

    public int size() {
        return size;
    }
}
