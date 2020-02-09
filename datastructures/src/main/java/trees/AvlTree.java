package trees;

public class AvlTree<R extends Comparable> {
    private Node<R> root;
    private int size;

    public void add(R data) {
        add(root, data);
        ++size;
    }

    private void add(Node<R> node, R data) {
        if (node == null) {
            root = new Node<>(data);
        }
        else if (data.compareTo(node.data) <= 0) {
            if (node.left == null) {
                node.left = new Node<>(data);
                node.left.parent = node;
            }
            else {
                // go left
                add(node.left, data);
            }
        }
        else if (data.compareTo(node.data) >= 0) {
            if (node.right == null) {
                node.right = new Node<>(data);
                node.right.parent = node;
            }
            else {
                // go right
                add(node.right, data);
            }
        }
        checkBalance(node);
    }

    public int height() {
        return height(root);
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

    private int heightDiff(Node<R> node) {
        if (node == null) return 0;
        else {
            int left = height(node.left);
            int right = height(node.right);
            return left - right;
        }
    }

    private void checkBalance(Node<R> node) {
        int heightDiff = heightDiff(node);
        if (heightDiff < -1 || heightDiff > 1) {
            // re-balance
            rebalance(node);
        }
        if (node.parent != null){
            checkBalance(node.parent);
        }
    }

    private void rebalance(Node<R> node) {
        // left heavy
        if (heightDiff(node) > 1) {
            // left heavy
            if (heightDiff(node.left) > 1) {
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
            if (heightDiff(node.left) > 1) {
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
        Node<R> temp = node.right;
        node.right = temp.left;
        temp.left = node;
        return temp;
    }

    private Node<R> rotateRight(Node<R> node) {
        // grandparent's left child saved
        Node<R> temp = node.left;
        // left of grandparent to be the temp's right child
        node.left = temp.right;
        // temp's right should point to the node.
        temp.right = node;
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
