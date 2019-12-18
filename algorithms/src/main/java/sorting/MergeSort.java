package sorting;

public class MergeSort {
    private int[] solve(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        breakArray(start, end, arr);
        return arr;
    }

    private void breakArray(int s, int e, int[] arr) {
        int mid = (s + e) / 2;
        breakArray(0, mid, arr);
        breakArray(mid + 1, e, arr);
    }

    public static void main(String[] args) {
        int[] arr = new int[] {-1, 8, 2, 0, 1};
        Helpers.printArray(new MergeSort().solve(arr));
    }
}
