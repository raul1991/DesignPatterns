package sorting;

public class BubbleSort {
    private int[] solve(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int [] arr = new int[] {-1, 2, 2, -2, -3};
        Helpers.printArray(new BubbleSort().solve(arr));
    }
}
