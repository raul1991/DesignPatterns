package problems.arraysandstrings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MatrixRotationTest {

    private MatrixRotation instance;
    private int[][] expected;

    @BeforeEach
    void setUp() {
        instance = new MatrixRotation();
        expected = generateSquareMatrix();
    }

    private int[][] generateSquareMatrix() {
        return new int[][]{
                {7, 4, 1},
                {8, 5, 2},
                {9, 6, 3}
        };
    }

    @Test
    void rotate() {
        Assertions.assertArrayEquals(expected, instance.rotate(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        }, 3, 3));
    }

    @Test
    void expectExceptionWhenMatrixIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                instance.rotate(null, 3, 3));
    }

    @Test
    void expectExceptionWhenNotSquareMatrix() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                instance.rotate(new int[][]{{1, 2, 3}, {1, 2, 4}}, 2, 3));
    }
}
