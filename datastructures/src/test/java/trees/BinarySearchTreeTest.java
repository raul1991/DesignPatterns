package trees;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {

    private BinarySearchTree<Integer> tree = new BinarySearchTree<>(20);

    @Before
    public void setUp() throws Exception {
        addNodes();
    }

    private void addNodes() {
        tree.add(1);
        tree.add(21);
        tree.add(15);
        tree.add(0);
        tree.add(16);
    }

    @Test
    public void add() {
        int oldSize = tree.getSize();
        tree.add(17);
        Assert.assertEquals(oldSize + 1, tree.getSize());
    }

    @Test
    public void search() {
        Assert.assertNotNull(tree.search(20));
        Assert.assertNotNull(tree.search(15));
        Assert.assertNull(tree.search(-1));
    }

    @Test
    public void smallest() {
        Assert.assertEquals(0, (int)tree.smallest().getValue());
    }

    @Test
    public void delete() {

    }

    @Test
    public void getParent() {
        // root has a null parent
        Assert.assertNull(tree.getParent());
        Assert.assertNotNull(tree.search(1).getParent());
    }

    @Test
    public void getValue() {
        Assert.assertNotNull(tree.getValue());
    }

    @Test
    public void getSize() {
        Assert.assertEquals(6, tree.getSize());
    }

    @Test
    public void isEmpty() {
        Assert.assertFalse(tree.isEmpty());
    }
}