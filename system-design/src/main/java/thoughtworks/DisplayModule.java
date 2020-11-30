package thoughtworks;

public interface DisplayModule<T> {
    void display(T info);
    void clear();
    void update(T info);
}
