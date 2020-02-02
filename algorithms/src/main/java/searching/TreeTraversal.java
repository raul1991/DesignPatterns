package searching;

import trees.BinarySearchTree;

import java.util.ArrayDeque;
import java.util.Queue;

public class TreeTraversal {

    private static void dfs(BinarySearchTree<Integer> node) {
        // go deep for each node
        if (node != null)
        {
            System.out.println(node.getValue());
            if (node.getLeft() != null)
            {
                dfs(node.getLeft());
            }
            if (node.getRight() != null)
            {
                dfs(node.getRight());
            }
        }
    }

    private static void bfs(BinarySearchTree<Integer> node) {
        // do a level order traversal
        Queue<BinarySearchTree<Integer>> queue = new ArrayDeque<>();
        queue.add(node);
        while (!queue.isEmpty())
        {
            BinarySearchTree<Integer> parent = queue.poll();
            System.out.println(parent.getValue());
            if (parent.getLeft() != null)
            {
                queue.add(parent.getLeft());
            }

            if (parent.getRight() != null)
            {
                queue.add(parent.getRight());
            }
        }
    }

    public enum TraversalOrder {
        INORDER,
        POSTORDER,
        PREORDER,
        LEVEL_ORDER // bfs
    }

    public void print(TraversalOrder order, BinarySearchTree<Integer> tree) {
        switch (order) {
            case INORDER:
                inorder(tree);
                break;
            case PREORDER:
                preorder(tree);
                break;
            case POSTORDER:
                postorder(tree);
                break;
            case LEVEL_ORDER:
                levelorder(tree);
                break;
            default:
                break;
        }
    }

    private void levelorder(BinarySearchTree<Integer> tree) {
        bfs(tree);
    }

    private void postorder(BinarySearchTree<Integer> tree) {
        if (tree == null) return;
        // left
        BinarySearchTree<Integer> left = tree.getLeft();
        if (left != null) {
            postorder(left);
        }
        // right
        BinarySearchTree<Integer> right = tree.getRight();
        if (right != null) {
            postorder(right);
        }
        // root
        System.out.printf("%d,", tree.getValue());
    }

    private void preorder(BinarySearchTree<Integer> tree) {
        if (tree == null) return;
        System.out.print(tree.getValue() +",");
        BinarySearchTree<Integer> left = tree.getLeft();
        if (left != null) {
            preorder(left);
        }
        BinarySearchTree<Integer> right = tree.getRight();
        if (right != null) {
            preorder(right);
        }
    }

    private void inorder(BinarySearchTree<Integer> tree) {
        if (tree == null) return;
        BinarySearchTree<Integer> left = tree.getLeft();
        if (left != null) {
            inorder(left);
        }
        System.out.print(tree.getValue() +",");
        BinarySearchTree<Integer> right = tree.getRight();
        if (right != null) {
            inorder(right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(0);
        tree.add(-1);
        tree.add(-2);
        tree.add(3);
        tree.add(2);
        tree.add(4);
//        dfs(tree);
//        bfs(tree);
        new TreeTraversal().print(TraversalOrder.PREORDER, tree);
        System.out.println();
        new TreeTraversal().print(TraversalOrder.POSTORDER, tree);
        System.out.println();
        new TreeTraversal().print(TraversalOrder.INORDER, tree);
    }
}
