package filereader.readers;

import filereader.RowCell;
import filereader.RowData;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class DelimitedFileParser {

    private String filePath;
    private String delimiter;

    public DelimitedFileParser(String filePath, String delimiter)
    {
        this.filePath = filePath;
        this.delimiter = delimiter;
    }

    public void parseFile() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)))) {
            processHeaders(Arrays.asList(reader.readLine().split(delimiter)));
            String line;
            while((line = reader.readLine()) != null)
            {
                processRows(new RowData(getRowCell(line)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private List<RowCell> getRowCell(String line) {

        String[] cellValues = line.split(delimiter);
        int len = cellValues.length;
        return IntStream.range(0, len).boxed().map(cellIdx -> getRowCell(cellValues[cellIdx], cellIdx)).collect(Collectors.toList());
    }

    private RowCell getRowCell(String cellValue, Integer cellIdx) {
        return new RowCell(cellValue, getHeaderName(cellIdx));
    }

    private String getHeaderName(int cellIndex) {
        return getHeaders().get(cellIndex);
    }

    public abstract List<String> getHeaders();

    public abstract void processHeaders(List<String> line);
    public abstract void processRows(RowData line);
    public String getDelimiter()
    {
        return delimiter;
    }

    public abstract List<RowData> getRows();
}
