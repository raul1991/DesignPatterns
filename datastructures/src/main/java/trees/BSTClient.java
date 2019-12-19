package trees;

public class BSTClient {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree(25);
        tree.add(11);
        tree.add(9);
        tree.add(20);
        tree.add(14);
        tree.add(21);
        tree.add(15);
        tree.add(26);
        tree.add(30);
        System.out.println(tree.getSize());
        BinarySearchTree foundNode = tree.search(14);
        if (foundNode != null) {
            System.out.println(foundNode.getParent().getValue());
        }
    }
}
