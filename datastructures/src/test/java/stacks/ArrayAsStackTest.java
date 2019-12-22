package stacks;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class ArrayAsStackTest {

    private static final int NO_OF_ITEMS_TO_PUSH = ArrayAsStack.MAX_CAPACITY;
    private ArrayAsStack<Integer> stack = new ArrayAsStack<>(NO_OF_ITEMS_TO_PUSH);

    @Before
    public void setUp() {
        IntStream.rangeClosed(1, NO_OF_ITEMS_TO_PUSH).forEach(stack::push);
    }

    @Test
    public void push() {
        // remove 1 item and then push
        stack.pop();
        int oldSize = stack.size();
        stack.push(1);
        assertEquals(oldSize + 1, stack.size());
    }

    @Test
    public void pop() {
        assertEquals(NO_OF_ITEMS_TO_PUSH, stack.size());
        stack.pop();
        assertEquals(NO_OF_ITEMS_TO_PUSH - 1, stack.size());
    }

    @Test
    public void isEmpty() {
        stack.clear();
        Assert.assertTrue(stack.isEmpty());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testUnderflow() {
        stack.clear();
        stack.pop();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testOverflow() {
        stack.push(1);
    }
}