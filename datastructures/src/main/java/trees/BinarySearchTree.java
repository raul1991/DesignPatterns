package trees;

import java.util.ArrayList;
import java.util.List;


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
    public BinarySearchTree<R> left;
    BinarySearchTree<R> right;

    public BinarySearchTree(R value) {
        this.data = value;
        this.left = null;
        this.right = null;
        this.parent = null;
        ++size;
    }

    public void add(R value) {
        if (value.compareTo(data) < 0) {
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

    public List<R> smallestElements() {
        List<R> smallestElements = new ArrayList<>();
        preorder(this, smallestElements);
        return smallestElements;
    }

    public void preorder(BinarySearchTree<R> tree, List<R> rs) {
        if (tree == null) return;
        BinarySearchTree<R> left = tree.getLeft();
        if (left != null) {
            preorder(left, rs);
        }
        rs.add(tree.getValue());
        BinarySearchTree<R> right = tree.getRight();
        if (right != null) {
            preorder(right, rs);
        }
    }

    /**
     * Returns the kth smallest element.
     * @param kth the desired smallest number
     * @return the number which is the smallest
     */
    public R smallest(int kth) {
        if (kth < 0 || kth > size)
            throw new IllegalArgumentException("Invalid index passed. Index should be between 1-" + (size - 1));
        else if (size == 1) return this.getValue();
        return smallestElements().get(kth - 1);
    }

    public R max() {
        if (size == 0) throw new IllegalStateException("Empty tree");
            // root is the max element.
        else if (size == 1) return this.getValue();
        else {
            BinarySearchTree<R> ptr = this.right;
            while (ptr.right != null) {
                ptr = ptr.right;
            }
            return ptr.getValue();
        }
    }
    // returns the first occurrence of the data
    public boolean contains(R data) {
        return search(data) != null;
    }

    /**
     * Returns the length of the max path from root to the leaf node.
     * @return the height of the tree.
     */
    public int height(BinarySearchTree<R> node) {
        if (node == null) return -1;
        int left = height(node.getLeft());
        int right = height(node.getRight());
        return Math.max(left, right) + 1;
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
            --size;
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
            --size;
            return value;
        }
    }

    public BinarySearchTree<R> getParent() {
        return this.parent;
    }

    public R getValue() {
        return this.data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public BinarySearchTree<R> getLeft() {
        return left;
    }

    public BinarySearchTree<R> getRight() {
        return right;
    }

    /**
     * Removes all the nodes in the tree
     */
    public void clear() {
        delete(this);
        size = 0;
    }

    private void delete(BinarySearchTree<R> node) {
        if (node == null) return;
        delete(node.getLeft());
        delete(node.getRight());
    }

    public boolean checkBST() {
        return checkBST(this);
    }

    private boolean checkBST(BinarySearchTree<R> root) {
        if (root == null) return false;
            // all good if we have reached leaf nodes.
        else if (root.left == null && root.right == null) return true;
        else {
            if ((root.left == null || root.left.data.compareTo(root.getValue()) > 0) ||
                    (root.right == null || root.right.data.compareTo(root.getValue()) < 0))
                return false;
            return checkBST(root.left) && checkBST(root.right);
        }
    }
}
