package searching;

import coursera.algorithmspart1.week2.LinkedQueue;
import trees.BinarySearchTree;

import java.util.ArrayDeque;
import java.util.LinkedList;
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

    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(0);
        tree.add(-1);
        tree.add(-2);
        tree.add(3);
        tree.add(2);
        tree.add(4);
        dfs(tree);
        bfs(tree);
    }
}
