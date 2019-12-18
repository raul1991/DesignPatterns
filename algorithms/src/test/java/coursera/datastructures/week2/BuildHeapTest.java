package coursera.datastructures.week2;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.stream.IntStream;

public class BuildHeapTest {

    @Test
    public void testBuildHeap() {
        File files = new File(Objects.requireNonNull(getClass().getClassLoader()
                .getResource("test-inputs-build-heap")).getFile());
        File[] in = files.listFiles(pathname -> pathname.isFile() && !pathname.getName().endsWith(".a"));
        IntStream.range(0, Objects.requireNonNull(in).length).forEach(idx -> {
            try {

                System.out.println("Input: " + in[idx].getPath());
                BuildHeap.FastScanner fastScanner = new BuildHeap.FastScanner(new FileReader(in[idx]));
                new BuildHeap().solve(fastScanner);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}