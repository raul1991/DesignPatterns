package thoughtworks;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DelimitedConfiguration implements BoardConfiguration {

    private final String delimiter;
    private final String input;

    public DelimitedConfiguration(String delimiter, String input) {
        this.delimiter = delimiter;
        this.input = input;
    }

    @Override
    public List<BoardCell> parseCells() {
        return Arrays.stream(input.split(delimiter))
                .map(s -> new BoardCell(createArtifact(s))).collect(Collectors.toList());
    }

    private CellArtifact createArtifact(String s) {
        return ;
    }
}
