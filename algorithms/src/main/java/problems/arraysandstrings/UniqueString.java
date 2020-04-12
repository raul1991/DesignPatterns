package problems.arraysandstrings;

/**
 * This problem is an easy problem if not understood in detail for in it lies the godly world of
 * unicode character sets. If you replace the 16 on line 9 to a 7, only 128 ascii characters could
 * be mapped and therefore some tests would fail. In order to support utf-16 this method uses << 16.
 */
public class UniqueString {

    private static final int[] charset = new int[1 << 16]; // a map of all possible utf-16 chars
    public boolean isUnique(String input) {
        if (input == null) return true;
        for (int i = 0; i < input.length(); i++)
        {
            if (charset[input.charAt(i)] != 0) return false;
            charset[input.charAt(i)] += 1;
        }
        return true;
    }

    public boolean isUniqueWithoutUsingAnyAdditionalSpace(String input)
    {
        if (input == null) return true;
        for (int i = 0; i < input.length(); i++)
        {
            for (int j = i + 1; j < input.length(); j++)
            {
                if (input.charAt(i) == input.charAt(j)) return false;
            }
        }
        return true;
    }
}
