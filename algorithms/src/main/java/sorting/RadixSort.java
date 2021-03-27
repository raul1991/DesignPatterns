package sorting;

import java.util.Arrays;
import java.util.stream.IntStream;

public class RadixSort {
    public static void main(String[] args) {
        new RadixSort().sort(new int[]{23, 1, 432, 14, 215});
    }

    private void sort(int[] arr) {
        int max = Arrays.stream(arr).reduce(Integer::max).orElseThrow(IllegalArgumentException::new);
        for (int place = 1; max / place > 0; place *= 10) { // O(d)
            countSort(arr, 10, arr.length, place); // O(d *(n + b))
            Helpers.printArray(arr);
            System.out.println();
        }
    }

    private void countSort(int[] arr, int base, int n, int place) {
        int[] b = new int[n]; // space: O(n)
        int[] counts = new int[base]; // space: O(b)
        // increment counts
        IntStream.range(0, n).forEach(i -> counts[(arr[i] / place) % 10] += 1); // O(n)
        // cumulative counts
        IntStream.range(1, 10).forEach(i -> counts[i] += counts[i - 1]); // O(b)
        // rearrange items
        for (int i = n - 1; i >= 0; i--) {
            b[counts[(arr[i] / place) % 10] - 1] = arr[i];
            counts[(arr[i] / place) % 10]--;
        }
        IntStream.range(0, n).forEach(i -> arr[i] = b[i]);
    }
}
