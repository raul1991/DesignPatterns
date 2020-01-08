package searching;

import java.util.Arrays;

/*
* A simple item by item search in an unsorted array. This can be done on
* a sorted array as well.
 */
public class LinearSearch {
    /**
     * Returns -1 or index of the item to be located.
     * @param item the item to locate
     * @return -1 or the zero based index of the item
     */
    private static int search(int[] arr, int item) {
        int pos = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == item) {
                pos = i;
                break;
            }
        }
        return pos;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 23, 41};
        int pos = search(arr, 23);
        System.out.println(pos > -1 ? "found @ " + pos : "Not found");
    }
}
