package trees;

import java.util.Comparator;

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
public class BinarySearchTree<R extends Comparable> {

    // total number of nodes.
    private int size;
    private R data;
    private BinarySearchTree<R> parent;
    private BinarySearchTree<R> left;
    private BinarySearchTree<R> right;

    public BinarySearchTree(R value) {
        this.data = value;
        this.left = null;
        this.right = null;
        this.parent = null;
        ++size;
    }

    public void add(R value) {
        if (value.compareTo(data) == -1) {
            // go left
            if (left == null) {
                left = new BinarySearchTree<R>(value);
            }
            else {
                left.add(value);
            }
            left.parent = this;
        }
        else {
            // go right
            if (right == null) {
                right = new BinarySearchTree<R>(value);
            }
            else {
                right.add(value);
            }
            right.parent = this;
        }
        ++size;
    }

    public BinarySearchTree<R> search(R value) {
        BinarySearchTree<R> curr = this;
        BinarySearchTree<R> foundNode = null;
        // always check the root
        if (curr.data.compareTo(value) == 0) return curr;
        // if nothing left to match.
        if (curr.left == null && curr.right == null) return null;
        // or in the left , if the value is smaller
        else if (curr.data.compareTo(value) > 0) {
            if (curr.left == null) return null;
            foundNode = curr.left.search(value);
        }
        // or in the right if the value is greater.
        else {
            if (curr.right == null) return null;
            foundNode = curr.right.search(value);
        }
        return foundNode;
    }

    public BinarySearchTree<R> smallest() {
        BinarySearchTree<R> begin = this;
        BinarySearchTree<R> smallest;
        // if has no left node or just one node, root is the smallest
        if (begin.left == null) return begin;
        // else
        // imagine root as the smallest element
        else {
            BinarySearchTree<R> pointer = begin.left;
            smallest = pointer;
            while ((pointer = pointer.left) != null) {
                if (pointer.data.compareTo(smallest.data) <= 0) {
                    smallest = pointer;
                }
            }
        }
        return smallest;
    }

    public R delete(R value) {
        if (isEmpty()) {
            // tree is empty
            return null;
        }
        // search what is to be deleted.
        BinarySearchTree<R> found = this.search(value);
        // return null if not found
        if (found == null) return null;
        // leaf node
        else if (found.left == null && found.right == null) {
            System.out.println("Root is what you deleted.");
            return found.data;
        }
        else {
            // non leaf node
            // find the smallest element, swap it with the value to be deleted
            BinarySearchTree<R> smallest = found.right.smallest();
            // swap values only
            R temp = found.data;
            found.data = smallest.data;
            smallest.data = temp;
            smallest = null;
            return value;
        }
    }

    public BinarySearchTree<R> getParent() {
        return this.parent;
    }

    public R getValue() {
        return this.data;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }
}
