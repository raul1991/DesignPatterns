package coursera.datastructures.week1;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.IntStream;

public class check_bracketsTest {

    @Test
    public void testInputs() {
        File files = new File(Objects.requireNonNull(getClass().getClassLoader()
                .getResource("test-inputs-brackets")).getFile());
        File[] in = files.listFiles(pathname -> pathname.isFile() && !pathname.getName().endsWith(".a"));
        IntStream.range(1, Objects.requireNonNull(in).length).forEach(idx -> {
            try {
                Files.lines(Paths.get(in[idx].getPath())).forEach(text -> {
                    String output = Bracket.BracketInterface.isOk(text);
                    String outputFile = in[idx] + ".a";
                    try {
                        String expected = Files.readAllLines(Paths.get(outputFile)).get(0);
                        Assert.assertEquals(expected, output);
                    } catch (IOException e) {
                        System.out.printf("Error reading the output file %s%n", outputFile);
                    }
                });
            } catch (IOException e) {
                System.out.println("Error reading input file" + in[idx]);
            }
        });

    }
}