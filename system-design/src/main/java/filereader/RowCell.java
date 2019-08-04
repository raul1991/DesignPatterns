package filereader;

import java.util.Comparator;

public class RowCell {
    private String value;
    private String headerName;

    public RowCell(String value, String headerName)
    {
        this.value = value;
        this.headerName = headerName;
    }

    public String getValue() {
        return value;
    }

    public String getHeaderName() {
        return headerName;
    }

}
