package filereader;

import java.util.LinkedList;
import java.util.List;

public class RowData {

    private final List<RowCell> rowCells;

    public RowData(List<RowCell> cells)
    {
        this.rowCells = new LinkedList<>(cells);
    }

    public List<RowCell> getRowCells() {
        return rowCells;
    }
}
