package problems.stacksandqueues;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

class NStackProblemTest {

    private static final int NSTACKS = 3;
    private NStackProblem problem = new NStackProblem(NSTACKS);

    @Test
    public void push() throws Exception {
        IntStream.range(0, NSTACKS).forEach(i -> {
            try {
                problem.push(NSTACKS * i + 1, i + 1);
            } catch (Exception e) {
                System.out.println(e);
            }
        });
        IntStream.range(0, NSTACKS).forEach(i -> Assertions.assertThat(problem.size(i + 1)).isEqualTo(1));
    }

    @Test
    public void pop() throws Exception {
        IntStream.range(0, NSTACKS).forEach(i -> {

        });
    }
}
