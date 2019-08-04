package filereader.interfaces;

import java.util.List;
import java.util.function.Function;

public interface Criteria {
    List<String> getSelection();
    List<String> groupByCols();
    List<String> outputHeaders();
}
