/**
 * An array is called Bitonic if it is comprises of an increasing sequence of integers followed immediately by a decreasing sequence of integers.
 * Given a bitonic array A of N distinct integers. Find a element X in it.
 *
 * Input:
 * First line will consist  a number T, the number of test cases. First line of each test case will consist of positive integer N. Next line contains array elements and third line contains X.
 *
 * Output:
 * Print the index where element found. If element not found, print "-1" (without quotes).
 *
 * Constraints:
 * 1 <= T <= 100
 * 1 <= N <= 107
 * -107 <= Ai <= 107
 *
 * Example:
 * Input:
 * 1
 * 5
 * 1 2 7 4 3
 * 2
 * Output:
 * 1
 *
 * Explanation:
 * Testcase 1: 2 is found at index 1 in the given array.
 * Reference : https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
 */

import java.io.*;

class GFG {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main (String[] args) throws IOException
    {
        int tc = Integer.parseInt(readNextLine());
        while (--tc >= 0)
        {
            int n = Integer.parseInt(readNextLine()); // no of numbers
            int[] arr = new int[n];
            String[] numberLine = readNextLine().split(" ");
            int max;
            int pivot = -1;
            for (int i = 0; i < n; i++)
            {
                max = arr[i] = Integer.parseInt(numberLine[i]);
                if (i != 0 && max < arr[i - 1])
                {
                    pivot = i - 1; // pivot found
                }
            }

            // before pivot
            final GFG gfg = new GFG();
            final int k = Integer.parseInt(readNextLine());
            if (pivot == -1)
            {
                writer.println(gfg.binSearch(arr, k, 0, n - 1));
            }
            else
            {
                if (arr[pivot] == k) writer.println(pivot);
                else
                {
                    int idx = gfg.binSearch(arr, k, 0, pivot - 1);
                    if (idx == -1)
                    {
                        idx = gfg.binSearch(arr, k, pivot + 1, n - 1);
                    }
                    writer.println(idx);
                }
            }
            writer.flush();
        }
    }

    public static String readNextLine() throws IOException
    {
        return reader.readLine();
    }

    public int binSearch(int[] arr, int k, int s, int e)
    {
        int l = s;
        int r = e;
        int m = (l + r)/2;
        int pos = -1;
        while (l <= r)
        {
            if (k < arr[m])
            {
                // exists in the left
                r = m - 1;
                m = (l + r) / 2;
            }
            else if (k > arr[m])
            {
                // exists in the right
                l = m + 1;
                m = (l + r) / 2;
            }
            else
            {
                pos = m;
                break;
            }
        }
        return pos;
    }
}