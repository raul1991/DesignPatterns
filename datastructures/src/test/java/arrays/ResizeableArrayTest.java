package arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class ResizeableArrayTest {

    private static final int NO_OF_ITEMS_TO_ADD = 10;
    private final ResizeableArray<Integer> array = new ResizeableArray<>();

    @Before
    public void setUp() {
        array.clear();
        addItems();
    }

    @Test
    public void add() {
        Assert.assertFalse(array.isEmpty());
        assertEquals(NO_OF_ITEMS_TO_ADD, array.size());
    }

    private void addItems() {
        IntStream.rangeClosed(1, NO_OF_ITEMS_TO_ADD).forEach(array::add);
    }

    @Test
    public void remove() {
        Integer itemDeleted = array.get(0);
        assertNotNull(array.remove(0));
        assertFalse(array.contains(itemDeleted));
    }

    @Test
    public void removeWithIndex() {
        // item at position 1
        Integer nextValue = array.get(1);
        // item at position 0
        Integer oldValue = array.get(0);
        assertNotNull(oldValue);
        // item removed at pos 0
        assertNotNull(array.remove(0));
        // assert that values shifted towards 0 po
        assertNotSame(oldValue, nextValue);
    }

    @Test
    public void contains() {
        Assert.assertFalse(array.contains(-1));
    }

    @Test
    public void get() {
        assertNotNull(array.get(0));
    }

    @Test
    public void isEmpty() {
        assertFalse(array.isEmpty());
    }

    @Test
    public void prepend() {
        Integer oldItemAtZero = array.get(0);
        array.prepend(4);
        Integer newItemAtZero = array.get(0);
        Assert.assertNotSame(oldItemAtZero, newItemAtZero);
        Assert.assertEquals(4, newItemAtZero.intValue());
    }
}
