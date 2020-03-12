package sorting;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {123, -3, 12, 1, 5, 2};
        new QuickSort().sort(arr, 0, arr.length - 1);
        Helpers.printArray(arr);
    }

    private void sort(int[] arr, int low, int high) {
        if (low < high) {
            // partition array
            int q = partition(arr, low, high);
            sort(arr, low, q - 1);
            sort(arr, q + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        // assume the pivot to be 'high'
        int pivot = arr[high];
        // assume partition index to be low
        int pIndex = low;
        // keep swapping if arr[i] <= pivot
        for (int i = low; i < high; i++) {
            if (arr[i] <= pivot) {
                swap(arr, i, pIndex);
                pIndex++;
            }
        }
        swap(arr, pIndex, high);
        return pIndex;
    }

    private void swap(int[] arr, int i, int pIndex) {
        int temp = arr[pIndex];
        arr[pIndex] = arr[i];
        arr[i] = temp;
    }
}
