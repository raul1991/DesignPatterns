package problems;

import java.util.HashMap;

/**
 * A kidnapper wants to write a ransom note by cutting out the words from a magazine. The objective of this program
 * is to print 'true' if it is possible to do so or 'false' otherwise.
 * For 'M' ransom words and 'N' magazine words, this algorithm has O(M + N) time complexity in the worst case scenario.
 */
public class RansomProblem
{
    public static void main(String[] args)
    {
        String[] magazine =new String[]{
                "money", "has", "been", "the", "ultimate", "passion",
                "for", "you", "and", "will", "remain", "so", "till", "you", "die",
                "Give", "something", "else", "to", "me", "or", "my", "soul", "eludes"
        };
        String[] ransomNote = new String[]{"Give", "me", "money", "or", "die"};
        System.out.println(new RansomProblem().isRansomNotePossible(magazine, ransomNote));
    }

    private boolean isRansomNotePossible(String[] magazine, String[] ransomNote)
    {
        HashMap<String, Integer> magazineWordCount = getStringCount(magazine);
        for (String ransomWord: ransomNote)
        {
            if (magazineWordCount.containsKey(ransomWord))
            {
                Integer count = magazineWordCount.get(ransomWord);
                if (count > 0)
                {
                    // decrement the count
                    magazineWordCount.put(ransomWord, count - 1);
                }
            }
            else return false;
        }
        return true;
    }

    private HashMap<String, Integer> getStringCount(String[] magazine)
    {
        HashMap<String, Integer> magazineChars = new HashMap<>(magazine.length);
        for (String s: magazine)
        {
            if (!magazineChars.containsKey(s))
            {
                magazineChars.put(s, 1);
            }
            else
            {
                Integer count = magazineChars.get(s);
                magazineChars.put(s, count + 1);
            }
        }
        return magazineChars;
    }
}
