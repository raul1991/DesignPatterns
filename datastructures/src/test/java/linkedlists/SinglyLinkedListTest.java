package linkedlists;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

public class SinglyLinkedListTest {

    private static final int TOTAL_ITEMS = 10;
    private SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

    @Before
    public void setUp() {
        list.clear();
        IntStream.range(0, TOTAL_ITEMS).forEach(list::add);
    }

    @Test
    public void isEmpty() {
        list.clear();
        Assert.assertTrue(list.isEmpty());
    }

    @Test
    public void getSize() {
        Assert.assertEquals(TOTAL_ITEMS, list.size());
    }

    @Test
    public void get() {
        Assert.assertTrue(IntStream.range(TOTAL_ITEMS - 1, 1).allMatch(i -> i == list.get(i)));
    }

    @Test
    public void add() {
        list.add(10);
        Assert.assertEquals(TOTAL_ITEMS + 1, list.size());
    }

    @Test
    public void append() {
        list.append(10);
        Assert.assertEquals(TOTAL_ITEMS + 1, list.size());
    }

    @Test
    public void remove() {
        int num = 8;
        Assert.assertEquals(TOTAL_ITEMS - num - 1, list.indexOf(num));
        list.remove(num);
        Assert.assertEquals(-1, list.indexOf(num));
        Assert.assertEquals(TOTAL_ITEMS - 1, list.size());
        list.remove(9);
        Assert.assertEquals(TOTAL_ITEMS - 2, list.size());
    }

    @Test
    public void clear() {
        list.clear();
        Assert.assertEquals(0, list.size());
    }

    @Test(expected = IllegalStateException.class)
    public void clearAndThenRemoveExpectException() {
        list.clear();
        list.remove(0);
    }

    @Test
    public void reverse() {
        Assert.assertEquals(9, list.getHead().intValue());
        list.reverse();
        Assert.assertEquals(0, list.getHead().intValue());
    }

    @Test
    public void isPalindrome() {
        list.clear();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(1);
        Assert.assertEquals(false, list.isPalindrome());
        list.clear();
        list.add(1);
        list.add(2);
        list.add(1);
        Assert.assertEquals(true, list.isPalindrome());
    }
}
