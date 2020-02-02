package trees;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {

    private BinarySearchTree<Integer> tree = new BinarySearchTree<>(20);

    @Before
    public void setUp() {
        tree.clear();
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
        int oldSize = tree.size();
        tree.add(17);
        assertEquals(oldSize + 1, tree.size());
    }

    @Test
    public void search() {
        assertNotNull(tree.search(20));
        assertNotNull(tree.search(15));
        assertNull(tree.search(-1));
    }

    @Test
    public void smallest() {
        assertEquals(0, (int)tree.smallest().getValue());
    }

    @Test
    public void delete() {
        assertNotNull(tree.search(20));
        assertNotNull(tree.delete(20));
        assertNull(tree.search(20));
    }

    @Test
    public void getParent() {
        // root has a null parent
        assertNull(tree.getParent());
        assertNotNull(tree.search(1).getParent());
    }

    @Test
    public void getValue() {
        assertNotNull(tree.getValue());
    }

    @Test
    public void size() {
        assertEquals(5, tree.size());
    }

    @Test
    public void isEmpty() {
        assertFalse(tree.isEmpty());
    }

    @Test
    public void height() {
        assertEquals(3, tree.height(tree));
    }

    @Test
    public void nthSmallest() {
        assertEquals(15, tree.smallest(3).intValue());
    }

    @Test
    public void max() {
        assertEquals(21, tree.max().intValue());
    }

    @Test
    public void contains() {
        assertFalse(tree.contains(30));
        tree.add(30);
        assertTrue(tree.contains(30));
    }

    @Test
    public void clear() {
        assertFalse(tree.size() == 0);
        tree.clear();
        assertEquals(0, tree.size());
    }

    @Test
    public void checkBST() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(22);
        // left sub tree
        tree.left = new BinarySearchTree<>(7);
        tree.left.left = new BinarySearchTree<>(6);
        tree.left.right = new BinarySearchTree<>(8);
        // right sub tree
        tree.right = new BinarySearchTree<>(27);
        tree.right.left = new BinarySearchTree<>(26);
        tree.right.right = new BinarySearchTree<>(28);
        assertTrue(tree.checkBST());
    }
}