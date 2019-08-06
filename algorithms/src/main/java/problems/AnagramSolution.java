package problems;

import java.util.stream.IntStream;

/**
 * This class returns a count of number of characters that must be removed from the two input strings
 * in order to make them valid anagrams.
 * For example : the strings 'hello' and 'billion' would form an anagram if the characters and their frequency in both
 * of them are same.
 */
public class AnagramSolution
{
    public static void main(String[] args)
    {
        final AnagramSolution anagramSolution = new AnagramSolution();
        System.out.println(anagramSolution.getCharactersToRemove("abca", "abbca"));
    }

    private int getCharactersToRemove(String s, String s1)
    {
        int[] charCounts1 = getCharCounts(s);
        int[] charCounts2 = getCharCounts(s1);
        return getDelta(charCounts1, charCounts2);
    }

    private int getDelta(int[] charCounts1, int[] charCounts2)
    {
        int sum = 0;
        if (charCounts1.length != charCounts2.length) return -1;
        else
        {
            for (int i = 0; i < charCounts1.length; i++)
            {
                sum += Math.abs(charCounts1[i] - charCounts2[i]);
            }

        }
        return sum;
    }

    private int[] getCharCounts(String s)
    {
        int[] counts = new int[26];
        IntStream.range(0, s.length()).forEach(index -> {
            final char c = s.charAt(index);
            final int pos = c - 'a';
            ++counts[pos];
        });
        return counts;
    }
}
