package problems.arraysandstrings;

/**
 * This algorithm will check if the bigger string is an anagram of the smaller
 * one or not. The following approaches are tried.
 *
 * 1. Brute force solution - we check for all the smaller string windows inside the bigger one.
 * Time complexity - O(B * S)
 * Space complexity - O(1)
 * Where B is the larger String and S is the smaller string's length
 * 2. Optimal solution - We create a frequency map (utf-16 char map) of the bigger string and return true if we have
 * the same frequency map for the smaller string. The optimization lies in the char map size (space)
 * and that we use the same for loop to check for same frequency map.
 * Time complexity - O(S)
 * Space complexity - O(1 << 16) or constant if that is all the chars we need.
 */
public class AnagramChecker {

    public boolean check(String bigger, String smaller)
    {
        if (bigger == null || smaller == null) return false;
        if (bigger.trim().isEmpty() || smaller.trim().isEmpty()) return false;
        int[] freqMap = new int[1 << 16]; // for utf-16 charset
        // build frequency map
        for (int i = 0; i < bigger.length(); i++) {
            freqMap[bigger.charAt(i)]++;
        }
        // now check the smaller string
        for (int i = 0; i < smaller.length(); i++) {
            char ch = smaller.charAt(i);
            if (freqMap[ch] < 0) return false;
            freqMap[ch]--;
        }
        return true;
    }
}
