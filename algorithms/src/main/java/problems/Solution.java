package problems;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    private static Map<Integer, Integer> duplicates;
    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int[] ranks = new int[alice.length];
        for (int i = 0; i < ranks.length; i++)
        {
            int m = findmitionUsingBinSearch(scores, alice[i]);
            // System.out.printf("Found %d @ m = %d\n", alice[i], m);
            // int dups = duplicates.get(scores[m]);
            // ranks[i] = m - dups + 1;
            System.out.printf("Found %d @ %d\n", alice[i], m);
        }
        return ranks;
    }

    private static int findmitionUsingBinSearch(int[] arr, int key)
    {
        int s = 0;
        int e = arr.length - 1;
        int pos = -1;
        while (s <= e)
        {
            int m = (s + e) / 2;
            if (arr[m] == key) pos = m;
            else if (arr[m] < key)
            {
                e = m - 1;
            }
            else
            {
                s = m + 1;
            }
        }
        // System.out.println("m = " + m + " s = " + s + " e = " + e);
        if (pos == -1)
        {
            if (s == arr.length - 1) return s + 1;
            else if (s == 0) return s - 1;
        }
        return pos;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        duplicates = new HashMap<>(100000);
        int lastCount = 0;
        for (int i = 0, j = 1; i < scoresCount; i++, j++) {
            // System.out.println(i + "," + j);
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
            if (j >= scoresCount) continue;
            int jItem = Integer.parseInt(scoresItems[j]);
            if (scoresItem == jItem)
            {
                ++lastCount;
            }
            duplicates.put(jItem, lastCount);
        }
        printArray(scores);
        // printArray(duplicates);
        System.out.println(duplicates);
        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);
        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

    static void printArray(int[] arr)
    {
        for(int i = 0; i < arr.length; i++)
        {
            System.out.printf("%d ", arr[i]);
        }
        System.out.println();
    }
}
