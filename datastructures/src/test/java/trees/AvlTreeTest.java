package trees;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.stream.IntStream;

public class AvlTreeTest {

    private AvlTree<Integer> tree;
    private int totalItems = 100;

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
        Assert.assertEquals(totalItems, tree.size());
        int height = tree.height();
        Assert.assertEquals(6, height);
    }

    @Test
    public void heightWithOneNode() {
        tree = new AvlTree<>();
        tree.add(0);
        Assert.assertEquals(1, tree.size());
        Assert.assertEquals(0, tree.height());
    }

    @Test
    public void heightWithNoNode() {
        tree = new AvlTree<>();
        Assert.assertEquals(0, tree.size());
        Assert.assertEquals(-1, tree.height());
    }
}