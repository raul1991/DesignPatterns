public class BSTClient
{
    public static void main(String[] args)
    {
        final BinarySearchTree<Integer> bstTree = new BinarySearchTree<>(1);
        bstTree.insert(100);
        bstTree.insert(-1);
        bstTree.insert(11);
        bstTree.insert(111);
        bstTree.insert(12);
        bstTree.insert(143);
        System.out.print("Pre - "); bstTree.printPreOrder();
        System.out.print("In - ");  bstTree.printInOrder();
        System.out.print("Post - "); bstTree.printPostOrder();
    }

    private static class BinarySearchTree<R>
    {
        private int data;
        private BinarySearchTree<R> left;
        private BinarySearchTree<R> right;

        private BinarySearchTree(int data)
        {
            this.data = data;
        }

        public boolean checkBST(BinarySearchTree<R> root)
        {
            return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        public boolean checkBST(BinarySearchTree<R> node, int min, int max)
        {
            if (node == null) return true;
            if (node.data < min || node.data > max) return false;
            // go left and right
            return checkBST(node, min, node.data - 1) && checkBST(node, node.data + 1, max);
        }

        public void insert(int value)
        {
            // value is the left
            if (value <= data)
            {
                // no left
                if (left == null)
                {
                    left = new BinarySearchTree<>(value);
                }
                else
                {
                    left.insert(value);
                }
            }
            // value should go in the right
            else
            {
                // no right
                if (right == null)
                {
                    right = new BinarySearchTree<>(value);
                }
                else
                {
                    right.insert(value);
                }
            }
        }

        public boolean contains(int value)
        {
            if (data == value)
            {
                // found
                return true;
            }
            else if (value < data)
            {
                if (left == null) return false;
                // check left
                return left.contains(value);
            }
            else
            {
                if (right == null) return false;
                return right.contains(value);
            }
        }
        // traverse left, root, node
        public void printInOrder() {
            if (left != null) {
                left.printInOrder();
            }
            System.out.print(data + " ");
            if (right != null) {
                right.printInOrder();
            }
        }

        // traverse left, root, node
        public void printPostOrder() {
            if (left != null) {
                left.printPostOrder();
            }
            if (right != null) {
                right.printPostOrder();
            }
            System.out.print(data + " ");
        }

        // traverse left, root, node
        public void printPreOrder() {
            System.out.print(data + " ");
            if (left != null) {
                left.printPreOrder();
            }
            if (right != null) {
                right.printPreOrder();
            }
        }
    }
}
