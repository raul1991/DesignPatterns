package problems.arraysandstrings;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class AnagramCheckerTest {

    private AnagramChecker instance;

    private static Stream<Arguments> checkAllCases() {
        String[][] inputs = new String[][]{
                {"abcabcssd", "cab", "true"}, // permutation 1
                {"abcabcssd", "acb", "true"}, // permutation 2
                {"abcabcssd", "bca", "true"}, // permutation 3
                {"abccadc", "", "false"},
                {null, "", "false"},
                {"¡™£¢∞™£¶","¡™£¢∞™£¶", "true"}
        };
        return Stream.of(inputs).map(Arguments::of);
    }

    @BeforeEach
    public void setup()
    {
        instance = new AnagramChecker();
    }

    @ParameterizedTest
    @MethodSource("checkAllCases")
    void check(String bigger, String smaller, boolean expected) {
        Assertions.assertThat(instance.check(bigger, smaller)).isEqualTo(expected);
    }
}