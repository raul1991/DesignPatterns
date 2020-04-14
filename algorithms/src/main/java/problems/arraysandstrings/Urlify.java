package problems.arraysandstrings;

/**
 * Problem name: Urlify
 * <p>
 * Statement: Given a string and its 'true' length, replace all the spaces inside it with "%20". In the previous sentence
 * true length means - all the characters except the empty spaces to accommodate the replacement.
 * <p>
 * Source: Cracking the coding interview, arrays and strings chapter, problem 1.3
 * <p>
 * Solution: Given the string with true length T of the complete char array C with spaces S, pattern is P,
 * actual length A is given as
 * A = T + S * length(P) - 1
 * Now knowing the actual length, we traverse from the back and swap characters if no space is encountered otherwise
 * we keep replacing the characters in C array with the pattern's characters.
 * Note:
 * One pointer starts at the end of true length and the other starts at the end of complete string's length
 */
public class Urlify {

    private int countSpaces(char[] chars, int trueLength)
    {
        int spaces = 0;
        for (int i = 0; i < trueLength; i++) {
            if (chars[i] == ' ') ++spaces;
        }
        return spaces;
    }

    private int actualLength(int trueLength, int noOfSpaces)
    {
        return trueLength + noOfSpaces * 2;
    }

    public char[] replace(char[] chars, int trueLength, char[] pattern)
    {
        if (trueLength == 0) return "".toCharArray();
        int actualLength = actualLength(trueLength, countSpaces(chars, trueLength));
        for (int i = trueLength - 1, j = actualLength - 1; i >= 0; i--) {
            if (chars[i] == ' ')
            {
                for (int k = pattern.length - 1; k >= 0; k--) {
                    chars[j--] = pattern[k];
                }
            }
            else {
                swap(chars, i, j--);
            }
        }
        return chars;
    }

    private void swap(char[] arr, int i, int j)
    {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
