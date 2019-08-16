package problems;

import java.util.Stack;

public class BalancedParantheses
{
    public static void main(String[] args)
    {
        String[] inputs = new String[]{
                "{{{{{{", ")"
        };
        final BalancedParantheses balancedParantheses = new BalancedParantheses();
        for (String in: inputs) {
            System.out.printf("%s ? - %s%n", in, balancedParantheses.isBalanced(in));
        }
    }

    private boolean isBalanced(String s) //O(n)
    {
        Stack<Character> characters = new Stack<>();
        for (int i = 0; i < s.length(); i++) // O(n)
        {
            char currBrace = s.charAt(i);
            if (!isClosingBrace(currBrace))
            {
                characters.push(currBrace);
            }
            else {
                // pop till we reach the matching opening brace
                if (characters.isEmpty() || !isAPair(currBrace, characters.pop()))
                {
                    return false;
                }
            }
        }
        return characters.isEmpty();
    }

    private boolean isAPair(char currBrace, char lastBrace)
    {
        int asciiSum = currBrace + lastBrace;
        switch (asciiSum)
        {
            case 123 + 125:
            case 91 + 93:
            case 40 + 41:
                return true;
            default:
                return false;
        }
    }

    private boolean isClosingBrace(char currBrace)
    {
        switch (currBrace)
        {
            case '}':
            case ']':
            case ')': return true;
            default: return false;
        }
    }
}
