package problems.arraysandstrings;

import java.util.Objects;

/**
 * Problem name: StringCompression
 * <p>
 * Statement: As per the problem the continuous repetitive characters are to be replaced with their count only if the
 * compressed string is of lesser length than the actual length.
 * <p>
 * An example:
 * aabbaabbbabc will become a2b2a2b3abc
 * See how we did not replace single characters we print the compressed string because they both differ in lengths.
 * <p>
 * Another example:
 * aabbccdd will remain the same because a1b1c1d1 has the same length as the original string.
 * <p>
 * Source: Cracking the coding interview, chapter arrays and strings, problem 1.4
 * <p>
 * Solution: We use a map to count the unique characters by their position in actual string.
 * For example, we make the following table for
 * a string "aabbabc"
 * Space: O(S) , where S is the original string's length
 * Time: O(S)
 * ______________
 * |  0   |  2  | => a
 * |  2   |  2  | => b
 * |  4   |  0  | => a
 * |  5   |  0  | => b
 * |  6   |  0  | => c
 * We maintain an overall sum say "OS" and we keep adding to it the running count "RC" and we check at the end if
 * the len(S) == OS, if true we return the original string otherwise we iterate over S and print characters with their
 * count in the map we created above.
 *
 * Now we iterate over the map
 */
public class StringCompression {

    public String compress(String input)
    {
        if (input == null) return null;
        else if (input.trim().equals("")) return input;
        int runningCount = 1; // to incorporate for 0 when no repetition is found.
        int originalLength = input.length();
        StringBuilder charset = new StringBuilder();
        char lastChar = input.charAt(0);
        for (int i = 1; i < originalLength; i++)
        {
            char newChar = input.charAt(i);
            if (lastChar == newChar)
            {
                runningCount++;
            }
            else
            {
                charset.append(lastChar).append(runningCount);
                runningCount = 1;
            }
            lastChar = newChar;
        }
        charset.append(lastChar).append(runningCount);
        return originalLength > charset.length() ? charset.toString() : input;
    }
}
