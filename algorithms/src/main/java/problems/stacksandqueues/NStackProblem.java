package problems.stacksandqueues;

/**
 * Problem name: N stack problem
 * <p>
 * Statement: Use a single array to create n stacks out of it and support the push and pop operations for individual
 * stacks.
 * <p>
 * Source: Cracking the coding interview, chapter 3, problem 1
 * <p>
 * Solution: <describe your solution>, formula, complexities
 */

public class NStackProblem {
    private int[] sizes; // stores size of each stack.
    private int[] values; // stores the elements.
    private int initSize = 3; // each stack
    private int capacity;

    public NStackProblem(int nstack) {
        values = new int[nstack * initSize];
        sizes = new int[nstack];
        capacity = nstack * initSize;
    }

    public int pop(int nstack) throws Exception {
        if (isEmpty(nstack)) throw new Exception("Underflow exception. Stack is empty.");
        int item = values[indexOfStack(nstack)];
        --sizes[nstack - 1];
        return item;
    }

    private boolean isEmpty(int nstack) {
        return sizes[nstack - 1] == 0;
    }

    public void push(int item, int nstack) throws Exception {
        if (isFull(nstack)) throw new Exception("Stack overflow");
        ++sizes[nstack - 1];
        int idx = indexOfStack(nstack);
        values[idx] = item;
    }

    private boolean isFull(int nstack) {
        return sizes[nstack - 1] == capacity;
    }

    private int indexOfStack(int nstack) {
        return (capacity % nstack) - 1 + sizes[nstack - 1];
    }

    public int size(int nstack) {
        return sizes[nstack - 1];
    }
}
