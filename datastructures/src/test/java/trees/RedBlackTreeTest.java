package trees;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

@Ignore
public class RedBlackTreeTest {

    private RedBlackTree<Integer> tree;
    private int totalItems = 10;
    private Random random = new Random();
    @Before
    public void setUp() {
        tree = new RedBlackTree<>();
        IntStream.range(0, totalItems).map(i -> random.nextInt(5000)).forEach(tree::add);
        Assert.assertEquals(totalItems, tree.size());
    }

    @Test
    public void add() {
        tree.add((int) (System.currentTimeMillis() % 100));
        Assert.assertEquals(totalItems + 1, tree.size());
    }

    @Test
    public void heightOfEmptyTree() {
        tree = new RedBlackTree<>();
        Assert.assertEquals(-1, tree.height());
    }

    @Test
    public void heightOfNodeWith1Nodes() {
        tree = new RedBlackTree<>();
        tree.add(0);
        Assert.assertEquals(1, tree.size());
        Assert.assertEquals(0, tree.height());
    }
}