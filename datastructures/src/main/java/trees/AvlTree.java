package trees;

public class AvlTree<R extends Comparable<R>> {
    private Node<R> root;
    private int size;

    public void add(R data) {
        Node<R> newNode = new Node<>(data);
        if (root == null) {
            root = newNode;
            ++size;
        }
        else {
            add(root, newNode);
        }
        checkBalance(newNode);
    }

    private void add(Node<R> parent, Node<R> newNode) {
        if (newNode.data.compareTo(parent.data) <= 0) {
            if (parent.left == null) {
                parent.left = newNode;
                newNode.parent = parent;
                ++size;
            }
            else {
                // go left
                add(parent.left, newNode);
            }
        }
        else if (newNode.data.compareTo(parent.data) > 0) {
            if (parent.right == null) {
                parent.right = newNode;
                newNode.parent = parent;
                ++size;
            }
            else {
                // go right
                add(parent.right, newNode);
            }
        }
    }

    public int height() {
        return height(root) - 1;
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
        int heightDiff = height(node.left) - height(node.right);
        if (heightDiff < -1 || heightDiff > 1) {
            // re-balance
            rebalance(node);
        }
        if (node.parent == null) return;
        checkBalance(node.parent);
    }

    private void rebalance(Node<R> node) {
        // left heavy
        if (height(node.left) - height(node.right) > 1) {
            // left heavy
            if (height(node.left.left) > height(node.left.right)) {
                node = rotateRight(node);
            }
            else {
                // left right rotate
                node = rotateLeftRight(node);
            }
        }
        else {
            // right heavy
            // right.left heavy
            if (height(node.right.left) > height(node.right.right)) {
                node = rotateRightLeft(node);
            }
            else {
                // right right heavy
                node = rotateLeft(node);
            }
        }
        if (node.parent == null) root = node;
    }

    /**
     * Return the new root node.
     * @param node the grandparent node
     * @return the new root node
     */
    private Node<R> rotateLeft(Node<R> node) {
        Node<R> p = node.parent;
        Node<R> temp = node.right;
        if (temp.left != null) {
            temp.left.parent = node;
        }
        if (p != null) {
            if (p.right == node) {
                p.right = temp;
            }
            else {
                p.left = temp;
            }
        }
        node.right = temp.left;
        temp.left = node;
        temp.parent = p;
        node.parent = temp;
        return temp;
    }

    private Node<R> rotateRight(Node<R> node) {
        Node<R> p = node.parent;
        // grandparent's left child saved
        Node<R> temp = node.left;
        if (temp.right != null) {
            temp.right.parent = node;
        }
        if (p != null) {
            if (p.right == node) {
                p.right = temp;
            }
            else {
                p.left = temp;
            }
        }        // left of grandparent to be the temp's right child
        node.left = temp.right;
        // temp's right should point to the node.
        temp.right = node;
        temp.parent = p;
        node.parent = temp;
        return temp;
    }


    private Node<R> rotateLeftRight(Node<R> node) {
        // left rotate parent
        node.left = rotateLeft(node.left);
        // right rotate grandparent
        return rotateRight(node);
    }

    private Node<R> rotateRightLeft(Node<R> node) {
        // right rotate parent
        node.right = rotateRight(node.right);
        // left rotate grandparent
        return rotateLeft(node);
    }

    public int size() {
        return size;
    }

    public class Node<R> {
        private R data;
        private Node<R> left;
        private Node<R> right;
        private Node<R> parent;

        public Node(R data) {
            this.data = data;
            this.right = null;
            this.left = null;
            this.parent = null;
        }
    }
}
