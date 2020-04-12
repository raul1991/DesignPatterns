package problems.arraysandstrings;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class UniqueStringTest {

    private UniqueString instance;

    @BeforeEach
    public void setup()
    {
        instance = new UniqueString();
    }

    private static Stream<Arguments> getArguments()
    {
        String[][] inputs = new String[][]{
                {"abc", "true"},
                {"aa", "false"},
                {"", "true"}, // alone string is unique
                {"√€", "true"},
                {"null", "false"}
        };
        return Stream.of(inputs).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("getArguments")
    @DisplayName("Test all inputs to see if a string is unique")
    public void testInputs(String input, boolean expected)
    {
        Assertions.assertThat(instance.isUnique(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("getArguments")
    @DisplayName("Test all inputs to see if a string is unique")
    public void testInputsWithoutAnyDS(String input, boolean expected)
    {
        Assertions.assertThat(instance.isUniqueWithoutUsingAnyAdditionalSpace(input)).isEqualTo(expected);
    }

}