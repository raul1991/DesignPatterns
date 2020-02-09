package trees;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class AvlTreeTest {

    private AvlTree<Integer> tree;
    private int totalItems = 10;
    private Random random = new Random();

    @Before
    public void setUp() {
        tree = new AvlTree<>();
        IntStream.range(0, totalItems).forEach(tree::add);
        Assert.assertEquals(totalItems, tree.size());
    }

    @Test
    public void add() {
        tree.add(33);
        Assert.assertEquals(totalItems + 1, tree.size());
    }

    @Test
    public void height() {
        Assert.assertEquals(5, tree.height());
    }
}