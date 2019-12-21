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
        if (curr == null) return null;
        // always check the root
        if (curr.data.compareTo(value) == 0) return curr;
        // if nothing left to match.
        if (curr.left == null && curr.right == null) return null;
        // or in the left , if the value is smaller
        else if (curr.data.compareTo(value) == 1) {
            foundNode = curr.left.search(value);
        }
        // or in the right if the value is greater.
        else {
            foundNode = curr.right.search(value);
        }
        return foundNode;
    }

    public BinarySearchTree<R> smallest() {
        BinarySearchTree<R> begin = this;
        if (begin != null) {
            boolean isLeafNode = false;
            while (!isLeafNode) {
                // keep finding the smallest node
                int compareTo = begin.getValue().compareTo(begin.right.getValue());
                if (compareTo <= 0) {
                    // go right
                    begin = begin.right;
                }
                else {
                    begin = begin.left;
                }
                isLeafNode = (begin.left == null && begin.right == null);
            }
            return begin;
        }
        return null;
    }

    public BinarySearchTree<R> delete(R value) {
        BinarySearchTree<R> found = this.search(value);
        R data = found.data;
        if (found == null) return null;
        // leaf node
        else if (found.left == null && found.right == null) {
            found = null;
        }
        else {
            // non leaf node
            BinarySearchTree<R> smallest = found.right.smallest();
            if (smallest == null) return null;
            // swap values only
            found.data = smallest.data;
        }
        return found;
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
}
