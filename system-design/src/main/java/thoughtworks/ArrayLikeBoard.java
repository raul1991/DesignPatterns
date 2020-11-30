package thoughtworks;

import java.util.List;

public class ArrayLikeBoard implements Board {
    private final BoardConfiguration config;
    private List<BoardCell> cells;
    private DisplayModule<String> displayModule;

    public ArrayLikeBoard(BoardConfiguration configuration, DisplayModule<String> displayModule) {
        this.config = configuration;
        this.displayModule = displayModule;
        this.cells = configuration.parseCells();
    }

    @Override
    public void init() {
        System.out.println("Clearing the board");
        displayModule.clear();
    }

    @Override
    public void render() {
        System.out.println("Rendering the board");
        cells.forEach(cell -> displayModule.update(cell.toString()));
    }

    @Override
    public void clear() {
        displayModule.clear();
    }

    @Override
    public CellArtifact fromPos(int pos) {
        return cells.get(pos).getArtifact();
    }

    @Override
    public boolean isValidPos(int pos) {
        return pos <= cells.size();
    }

}
