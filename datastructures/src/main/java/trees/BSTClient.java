package trees;

public class BSTClient {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>(20);
        tree.add(1);
        tree.add(2);
        tree.add(23);
        tree.add(21);
        BinarySearchTree f = tree.search(1);
        printValueIfFound(f);
        f = tree.search(20);
        printValueIfFound(f);
        f = tree.search(211);
        printValueIfFound(f);
//        System.out.println(tree.smallest());
    }

    private static void printValueIfFound(BinarySearchTree f) {
        if (f != null) {
            System.out.println(f.getParent().getValue());
        }
        else {
            System.out.println("Not found!");
        }
    }
}
