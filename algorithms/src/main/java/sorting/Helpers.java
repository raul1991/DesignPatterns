package sorting;

import java.util.Arrays;

public class Helpers {

    private Helpers(){}

    public static void printArray(int[] array) {
        Arrays.stream(array).forEach(System.out::print);
    }
}
