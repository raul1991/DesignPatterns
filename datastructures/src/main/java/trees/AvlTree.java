package trees;

public class AvlTree<R extends Comparable<R>> {
    private int size;
    private Node<R> root;

    public AvlTree() {
        this.size = 0;
        this.root = null;
    }

    public Node<R> add(R data) {
        Node<R> newNode = new Node<>(data);
        if (root == null) {
            root = newNode;
        }
        else {
            add(root, newNode);
        }
        size++;
        // check if balance is disturbed
        checkBalance(newNode);
        return newNode;
    }

    public int height() {
        return height(root) - 1;
    }

    public int size() {
        return size;
    }

    // height of a node
    private int height(Node<R> node) {
        if (node == null) return 0;
        else {
            int left = height(node.left);
            int right = height(node.right);
            return Math.max(left, right) + 1;
        }
    }

    private void checkBalance(Node<R> node) {
        // find height difference
        int heightDiff = height(node.left) - height(node.right);
        if (heightDiff < -1 || heightDiff > 1) {
            rebalance(node, heightDiff);
        }
        if (node.parent == null) return;
        // go up one parent.
        checkBalance(node.parent);
    }

    private void rebalance(Node<R> node, int heightDiff) {
        if (heightDiff > 1) {
            // left heavy
            heightDiff = height(node.left.left) - height(node.left.right);
            if (heightDiff >= 1) {
                // left left heavy - right rotation needed
                node = rotateRight(node);
            }
            else {
                node = rotateLeftRight(node);
            }
        }
        else if (heightDiff < -1) {
            // right heavy
            heightDiff = height(node.right.right) - height(node.right.left);
            if (heightDiff >= 1) {
                // right right heavy
                node = rotateLeft(node);
            }
            else {
                node = rotateRightLeft(node);
            }
        }
        // if root gets displaced during a rebalance, the node that is currently at the root becomes the new root.
        if (node.parent == null) root = node;
    }

    private void add(Node<R> parent, Node<R> newNode) {
        if (parent.data.compareTo(newNode.data) <= 0) {
            if (parent.right == null) {
                // add as right child of this parent
                parent.right = newNode;
                newNode.parent = parent;
            }
            else {
                add(parent.right, newNode);
            }
        }
        else {
            if (parent.left == null) {
                // add as left child of this parent
                parent.left = newNode;
                newNode.parent = parent;
            }
            else {
                add(parent.left, newNode);
            }
        }
    }

    /**
     * Rotates the grandparent to the left.
     * Example:
     *      1       <<<<< Current Grandparent                                                           2 (temp)
     *       \                                                                                        /    \
     *        2     <<<<< Temp (parent)                         ---Left rotate Grandparent---->     1       3
     *         \
     *          3   <<<<  new node disturbs the balance
     *
     * @param grandparent the current grandparent
     * @return the right child of the current grandparent
     */
    public Node<R> rotateLeft(Node<R> grandparent) {
        Node<R> parent = grandparent.parent;
        Node<R> temp = grandparent.right;
        if (temp.left != null) {
            temp.left.parent = grandparent;
        }
        if (parent != null) {
            if (parent.left == grandparent) {
                // temp should become grandparent's parent's left child
                parent.left = temp;
            }
            else {
                // else it becomes the right child
                parent.right = temp;
            }
        }
        grandparent.right = temp.left;
        temp.left = grandparent;
        // adjust the parents of rearranged nodes
        temp.parent = parent;
        grandparent.parent = temp;
        return temp;
    }

    /**
     * Rotates the grandparent to the right.
     * Example:
     *          0  <<<<< Current Grandparent                                                                         -1 (temp)
     *        /                                                                                             /   \
     *      -1     <<<<< Temp (parent)                         ---Right rotate Grandparent---->           -2     0
     *      /
     *     -2       <<<<  new node disturbs the balance
     *
     * @param grandparent the current grandparent
     * @return the left child of the current grandparent
     */
    public Node<R> rotateRight(Node<R> grandparent) {
        Node<R> parent = grandparent.parent;
        Node<R> temp = grandparent.left;
        if (temp.right != null) {
            temp.right.parent = grandparent;
        }
        if (parent != null) {
            if (parent.left == grandparent) {
                // temp should become grandparent's parent's left child
                parent.left = temp;
            }
            else {
                // else it becomes the right child
                parent.right = temp;
            }
        }
        grandparent.left = temp.right;
        temp.right = grandparent;
        // adjust the parents of rearranged nodes
        temp.parent = parent;
        grandparent.parent = temp;
        return temp;
    }

    private Node<R> rotateRightLeft(Node<R> node) {
        Node<R> rightRotated = rotateRight(node);
        return rotateLeft(rightRotated);
    }

    public Node<R> rotateLeftRight(Node<R> node) {
        Node<R> leftRotated = rotateLeft(node);
        return rotateRight(leftRotated);
    }

    public void clear() {
        size = 0;
        root = null;
    }

    private static class Node<R> {
        private Node<R> parent;
        private Node<R> left;
        private Node<R> right;
        private R data;

        private Node(R data) {
            this.parent = null;
            this.left = null;
            this.right = null;
            this.data = data;
        }
    }

}
