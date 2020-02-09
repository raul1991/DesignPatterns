package sorting;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class CountingSort {
    public static void main(String[] args) {
        int[] arr = new int[] {2, 4, 2, 5, 1, 6};
        OptionalInt max = IntStream.range(0, arr.length + 1).reduce(Integer::max);
        if (max.isPresent()) {
            new CountingSort().apply(arr, max.getAsInt());
        }
    }

    private void apply(int[] arr, int range) {
        // stores frequency of the elements in 'arr'.
        int[] b = new int[arr.length];
        int[] count = new int[range + 1]; // to be exactly the size
        // Update the frequency
        IntStream.range(0, arr.length).forEach(i -> ++count[arr[i]]);
        // cumulative counts (previous + this count)
        IntStream.range(1, count.length).forEach(i -> count[i] += count[i - 1]);
        Helpers.printArray(count);
        System.out.println();
        IntStream.range(0, range).forEach(i -> b[--count[arr[i]]] = arr[i]);
        Helpers.printArray(arr);
        System.out.println();
        Helpers.printArray(b);
    }

}
