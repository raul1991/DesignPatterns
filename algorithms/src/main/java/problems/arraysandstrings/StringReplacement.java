package problems.arraysandstrings;

import java.util.Arrays;
import java.util.stream.IntStream;

public class StringReplacement {

    public static void main(String[] args) {
        String expectedString = "Hel%20lo%20World";
        String inputStr = "Hel lo World    ";
        System.out.printf("Actual length = %d%n", inputStr.length());
        char[] actualString = replaceString(inputStr, "Hel lo World".length(), "%20");
        System.out.println(actualString);
    }

    private static char[] replaceString(String inputStr, int truelength, String s) {
        // calculate the spaces
        char[] arr = inputStr.toCharArray();
        long count = IntStream.range(0, truelength).filter(i -> arr[i] == ' ').count();
        int index = truelength + (int) count * 2;
        for (int i = truelength - 1; i >= 0; i--) {
            if (arr[i] == ' ') {
                arr[index - 1] = '0';
                arr[index - 2] = '2';
                arr[index - 3] = '%';
                index -= 3;
            }
            else {
              arr[index - 1] = arr[i];
              index -= 1;
            }
        }
        return arr;
    }


}
