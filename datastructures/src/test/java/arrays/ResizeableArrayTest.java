package arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class ResizeableArrayTest {

    private static final int NO_OF_ITEMS_TO_ADD = 10;
    private ResizeableArray<Integer> array = new ResizeableArray<>();
    private Random random = new Random();

    @Before
    public void setUp() {
        array.clear();
        addRandomItems(NO_OF_ITEMS_TO_ADD);
    }

    @Test
    public void add() {
        Assert.assertFalse(array.isEmpty());
        assertEquals(array.size(), NO_OF_ITEMS_TO_ADD);
    }

    private void addRandomItems(int noOfItemsToAdd) {
        IntStream.rangeClosed(1, noOfItemsToAdd).map(i -> random.nextInt(NO_OF_ITEMS_TO_ADD * 10)).forEach(array::add);
    }

    @Test
    public void remove() {
        assertNotNull(array.remove(0));
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
}