package trees;

/**
 * This class is a representation of the BinarySearch Tree which supports the
 * following operations.
 * 1. Add a node - adds a new node
 * 2. Remove a node - removes a node
 * 3. get the height - returns the height of the tree
 * 4. print - INORDER, POSTORDER, PREORDER, LEVELORDER as agruments.
 * 5. find - finds a node in the tree
 * @param <R> - The input type
 */
public class BinarySearchTree<R> {

    // total number of nodes.
    private int size;
    private int data;
    private BinarySearchTree<R> parent;
    private BinarySearchTree<R> left;
    private BinarySearchTree<R> right;

    public BinarySearchTree(int value) {
        this.data = value;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

    public void add(int value) {
        if (value <= data) {
            // go left
            if (left == null) {
                left = new BinarySearchTree<>(value);
            }
            else {
                left.add(value);
            }
            left.parent = this;
        }
        else {
            // go right
            if (right == null) {
                right = new BinarySearchTree<>(value);
            }
            else {
                right.add(value);
            }
            right.parent = this;
        }
        ++size;
    }

    public BinarySearchTree search(int value) {
        BinarySearchTree curr = this;
        BinarySearchTree foundNode = null;
        // maybe this itself
        if (curr.data == value) {
            foundNode = curr;
        }
        // or in the left , if the value is smaller
        else if (curr.data > value) {
            foundNode = curr.left.search(value);
        }
        // or in the right if the value is greater.
        else {
            foundNode = curr.right.search(value);
        }
        return foundNode;
    }

    public BinarySearchTree<R> getParent() {
        return this.parent;
    }

    public int getValue() {
        return this.data;
    }

    public int getSize() {
        return size;
    }
}
