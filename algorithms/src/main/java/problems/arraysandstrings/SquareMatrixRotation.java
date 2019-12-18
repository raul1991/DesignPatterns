package problems.arraysandstrings;

import java.util.Random;

public class SquareMatrixRotation {

    private static Random r = new Random();

    private static void rotateMatrix(int matrix[][], int n) {
      // loop for layers
        for (int layer = 0; layer < n/2; layer++) {
            int last = n - layer - 1;
            // for for each value in the layer except the last one
            for (int i = layer; i < last; i++) {
                int offset = i - layer;
                // save top
                int top = matrix[layer][i];
                // top <- left
                matrix[layer][i] = matrix[last - offset][layer];
                // left <- bottom
                matrix[last - offset][layer] = matrix[last][last - offset];
                // bottom <- right
                matrix[last][last - offset] = matrix[i][last];
                // right <- top
                matrix[i][last] = top;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = generateMatrix(5);
        System.out.println("Before rotation");
        printMatrix(matrix);
        rotateMatrix(matrix, 5);
        System.out.println("After rotation");
        printMatrix(matrix);
    }

    private static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = r.nextInt(n * n) + 1;
            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
