package filereader.readers;

import filereader.RowData;

import java.util.LinkedList;
import java.util.List;

public class CsvParser extends DelimitedFileParser {

    private List<String> headers = new LinkedList<>();
    private List<RowData> rows = new LinkedList<>();

    public CsvParser(String filePath, String delimiter) {
        super(filePath, delimiter);
    }

    @Override
    public List<String> getHeaders() {
        return headers;
    }

    @Override
    public void processHeaders(List<String> line) {
        headers.addAll(line);
    }

    @Override
    public void processRows(RowData rowData) {
        rows.add(rowData);
    }

    @Override
    public List<RowData> getRows() {
        return new LinkedList<>(rows);
    }
}
