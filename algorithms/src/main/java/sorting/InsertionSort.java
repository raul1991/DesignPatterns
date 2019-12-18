package sorting;

import java.util.Arrays;

/**
 * An insertion sort is a sorting algorithm with the following features.
 *
 * 1. time complexity - O(n^2)
 * 2. space complexity - C * O(n) (where C is a constant)
 *
 * Pseudo code
 *
 * 1. for j = 1 to array.length
 * 2.   key = array[j]
 * 3.   i = j - 1
 * 4.   while i > -1 and key < array[i]
 * 5.       array[i + 1] = array[i]
 * 6.       i = i - 1
 * 7.   array[i + 1] = key
 *
 * Explanation
 * -------------------
 * Take this as a way you sort a deck of cards in your hand where you already have a card in your hand and you also
 * pick one card from a deck of cards on the table. Each time you do so, you try to find a place for the newer card
 * and keep on shifting the already held cards into the next position.
 * Once position is found, you place the newer card there.
 * */
public class InsertionSort {

    public static void main(String[] args) {
        printArray(new InsertionSort().apply(new int[]{11,2,-3,4,12,-9}));
    }

    private static void printArray(int[] array) {
        Arrays.stream(array).forEach(System.out::println);
    }

    private int[] apply(int[] nums) {
        for (int j = 1, length = nums.length; j < length; j++)
        {
            // step 1. pick a card
            int key = nums[j];
            // already sorted hand (0 to j-1)
            int i = j - 1;
            // step 2. while the picked card is not compared with all cards in the sorted hand, keep swapping, decreasing
            // i
            while (i > -1 && key < nums[i])
            {
               // move the elements to right
               nums[i + 1] = nums[i];
               // compare with the next card in the sorted hand
               i = i - 1;
            }
            // exit as soon as we find a position for the newly picked card at step 1
            nums[i + 1 ] = key;
        }
        return nums;
    }
}
