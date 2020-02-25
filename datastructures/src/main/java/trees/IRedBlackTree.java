package trees;

public interface IRedBlackTree<R extends Comparable<R>> {
    void add(R data);
    int height();
    int size();
}
