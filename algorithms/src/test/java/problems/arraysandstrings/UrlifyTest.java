package problems.arraysandstrings;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class UrlifyTest {

    private Urlify instance;

    private static Stream<Arguments> getArguments() {
        Object[][] args = new Object[][]{
                {"H ELL     ", 6, "H%20ELL%20"},
                {"MR JO HAN DOE      ", 13, "MR%20JO%20HAN%20DOE"},
                {"         ", 3, "%20%20%20"},
                {"", 0, ""}, // nothing, input == output
                {"   ", 1, "%20"}, // just one space
                {"%20", 3, "%20"} // remains the same
        };
        return Stream.of(args).map(Arguments::of);
    }

    @BeforeEach
    void setUp() {
        instance = new Urlify();
    }

    @ParameterizedTest
    @MethodSource("getArguments")
    public void testReplace(String input, int trueLength, String expectedString)
    {
        Assertions.assertThat(instance.replace(input.toCharArray(), trueLength, "%20".toCharArray()))
                .isEqualTo(expectedString.toCharArray());
    }
}