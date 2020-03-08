package linkedlists;

import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class DoublyLinkedListTest {

    private static final int TOTAL_ITEMS = 10;
    private DoublyLinkedList<Integer> dList = new DoublyLinkedList<>();

    @Before
    public void setUp() {
        IntStream.range(0, TOTAL_ITEMS).forEach(dList::add);
    }

    @Test
    public void add() {
        dList.add(14);
        assertEquals(TOTAL_ITEMS + 1, dList.size());
        assertEquals(14, dList.get(0).intValue());
    }

    @Test
    public void addWithPosition() {
        dList.add(10, 3);
        assertEquals(TOTAL_ITEMS + 1, dList.size());
        assertEquals(10, dList.get(3).intValue());
    }

    @Test
    public void getAtPosition() {
        boolean allMatch = IntStream.rangeClosed(TOTAL_ITEMS - 1, 0).allMatch(i -> dList.get(i).equals(i));
        assertTrue(allMatch);
    }

    @Test
    public void clear() {
        dList.clear();
        assertEquals(0, dList.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void remove() {
        dList.remove(3);
        assertNotSame(3, dList.get(3));
        dList.remove(-1);
    }

    @Test(expected = IllegalStateException.class)
    public void removeWhenListEmpty() {
        dList.clear();
        dList.remove(0);
    }

    @Test
    public void removeTheFirstInsertedItem()
    {
        int lastItem = dList.get(dList.size() - 1);
        int firstToLastItem = dList.get(dList.size() - 2);
        assertEquals(0, lastItem);
        dList.remove();
        // second last becomes the new last item
        assertEquals(firstToLastItem, dList.get(dList.size() - 1).intValue());
    }
}