package thoughtworks;

public interface Board {
    //todo: add docs
    void init();
    void render();
    void clear();
    CellArtifact fromPos(int pos);

    boolean isValidPos(int pos);
}
