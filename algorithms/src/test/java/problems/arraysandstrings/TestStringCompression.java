package problems.arraysandstrings;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Problem name: TestStringCompression
 * <p>
 * Statement: <describe the problem here>
 * <p>
 * Source: <where did you read it from, a url, chapter number, book name etc>
 * <p>
 * Solution: <describe your solution>, formula, complexities
 */
class TestStringCompression {

    private StringCompression instance;

    private static Stream<Arguments> getArguments() {
        String[][] inputs = new String[][]{
                {"aabbaabb", "aabbaabb"},
                {generateChars('a', 1000), "a1000"},
                {"aaabbaabb", "a3b2a2b2"},
                {null, null},
                {"", ""}
        };
        return Stream.of(inputs).map(Arguments::of);
    }

    private static String generateChars(char ch, int times) {
        StringBuilder builder = new StringBuilder();
        IntStream.range(0, times).forEach(i -> builder.append(ch));
        return builder.toString();
    }

    @BeforeEach
    void setUp() {
        instance = new StringCompression();
    }

    @ParameterizedTest
    @MethodSource("getArguments")
    void compress(String input, String expected) {
        Assertions.assertThat(instance.compress(input)).isEqualTo(expected);
    }
}
