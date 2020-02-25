package trees;

/**
 * Red black trees, unlike AVL trees, expect the nodes to be either red or black.
 * - All inserted nodes are red.
 * - Root and null nodes are black.
 * - There should be equal number of black nodes from all paths from root to the leaf nodes.
 * - There should not be any two consecutive red nodes.
 *
 * Balancing rules
 * -------------------------
 * The balance is maintained sometimes using the rotations, like the AVL trees, and sometimes by color flipping.
 *
 * Rules for rotations,
 * -------------------------
 * - Left rotation - If the node inserted that caused the violation is in the RIGHT side's RIGHT subtree
 * Example: Here 6 is in the RIGHT side's RIGHT subtree
 *                  3                                           5
 *                   \                                        /  \
 *                    5         ---Left rotate 3---->        3    6
 *                     \
 *                      6
 * - Right rotation - If the node inserted that caused the violation is in the LEFT side's LEFT subtree
 * Example: Here 0 is the node that caused the violation and is the LEFT side's LEFT subtree.
 *                  3                                            1
 *                /                                            /  \
 *              1               ---Right rotate 3---->        0    3
 *             /
 *            0
 *
 * - Left Right rotation - If the node that caused the violation is in the Right child's Left subtree.
 * Example: Here 4 is in the Left side's Right's subtree
 *                  6                                       6                               4
 *                /                                       /                               /  \
 *               2          ---Left rotate 2---->       4   ---Right rotate 6---->       2    6
 *                \                                   /
 *                 4                                2
 * - Right Left rotation - If the node that caused the violation is in the RIGHT side's LEFT subtree
 * Example: Here
 *                  4                                   4                                         5
 *                   \                                   \                                      /  \
 *                    6    ---Right rotate 6---->         5     ---Left rotate 4---->          4    6
 *                   /                                     \
 *                 5                                        6
 *
 * After rotation, the parent will be black and the children will be red
 * After color flip, the parent will be red and the children will be black
 *
 * Rules for color flipping
 * --------------------------
 * If the inserted node's aunt is BLACK, we rotate
 * else if the node's aunt is RED, we color flip.
 *
 * @param <R> the type to create this tree with
 */
public class RedBlackTree<R extends Comparable<R>> implements IRedBlackTree<R> {

    private Node<R> root;
    private int size;

    @Override
    public void add(R data) {
        Node<R> newNode = new Node<>(data);
        if (root == null) {
            root = newNode;
            root.isBlack = true;
            root.isLeft = false;
        }
        else {
            add(root, newNode);
        }
        ++size;
    }

    private void add(Node<R> parent, Node<R> newNode) {
        if (newNode.isBigger(parent)) {
            // going right
            if (parent.right == null) {
                // space available for insertion
                parent.right = newNode;
                newNode.parent = parent;
            }
            else {
                add(parent.right, newNode);
            }
        }
        else {
            // going left
            if (parent.left == null) {
                // space available for insertion
                parent.left = newNode;
                newNode.parent = parent;
            }
            else {
                add(parent.left, newNode);
            }
        }
    }

    private int height(Node<R> node) {
        if (node == null) return 0;
        else {
            int left = height(node.left);
            int right = height(node.right);
            return Math.max(left, right) + 1;
        }
    }

    @Override
    public int height() {
        if (root == null) return -1;
        else return height(root) - 1;
    }

    @Override
    public int size() {
        return size;
    }

    public class Node<R extends Comparable<R>>
    {
        private final R data;
        private Node<R> parent;
        private Node<R> left;
        private Node<R> right;
        private boolean isLeft;
        private boolean isBlack;

        public Node(R data) {
            this.parent = null;
            this.left = null;
            this.right = null;
            this.isBlack = false;
            this.isLeft = false;
            this.data = data;
        }

        public boolean isLeft() {
            return this.isLeft;
        }

        public boolean isRed() {
            return !this.isBlack;
        }

        public boolean isRight() {
            return !this.isLeft;
        }

        public R getData() {
            return data;
        }
        /**
         * If 'this' node is the left child then the aunt would be in the right else left side.
         * @param node the node whose aunt is needed
         * @return this node's aunt
         */
        public Node<R> getAunt(Node<R> node) {
            if (node.isLeft()) {
                return node.parent != null ? node.parent.parent.right : null;
            }
            return node.parent != null ? node.parent.parent.left : null;
        }

        public boolean isAuntBlack(Node<R> node) {
            return !getAunt(node).isRed();
        }

        /**
         * Returns true if the new node deserves to be the left child of 'this' node.
         * @param node the node to check against
         * @return
         */
        public boolean isBigger(Node<R> node) {
            return this.data.compareTo(node.data) > 0;
        }
    }
}
