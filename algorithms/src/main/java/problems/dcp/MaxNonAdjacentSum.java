package problems.dcp;

import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MaxNonAdjacentSum {
    private int[] cached;

    public int maxSum(int[] arr) {
        cached = new int[arr.length];
        return maxSumMemoized(arr, arr.length - 1);
    }

    public int maxSum(int[] arr, int i) {
        if (i == 0) return arr[0];
        else if (i == 1) return Math.max(arr[i - 1], arr[i]);
        return Math.max(maxSum(arr, i - 1), arr[i] + maxSum(arr, i - 2));
    }

    public int maxSumMemoized(int[] arr, int i) {
        if (i == 0) return arr[0];
        else if (i == 1) return Math.max(arr[i - 1], arr[i]);
        if (cached[i] != 0) return cached[i];
        int max = Math.max(maxSumMemoized(arr, i - 1), arr[i] + maxSumMemoized(arr, i - 2));
        cached[i] = max;
        return max;
    }

    /**
     * The intuition is that we have to either include the current number or we use previously excluded sum +
     * @param arr
     * @return
     */
    public int maxSumConstSpace(int[] arr) {
        // including first number
        int incl = arr[0];
        // since we are at index 0, so if we exclude this number, there is no sum so we put it as 0
        int excl = 0;
        int maxSoFar = 0;
        print(0, maxSoFar, incl, excl);
        for(int i = 1; i < arr.length; i++) {
            maxSoFar = Math.max(incl, excl);
            incl = excl + arr[i];
            excl = maxSoFar;
            print(i, maxSoFar, incl, excl);
        }
        return Math.max(incl, excl);
    }

    void print(int... args) {
        System.out.printf("i = %d, maxSoFar = %d, incl = %d, excl = %d", args[0], args[1], args[2], args[3]);
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println(new MaxNonAdjacentSum().maxSumConstSpace(new int[] {
            5, 0, 3, 2, 1, 4
        }));
    }
}
