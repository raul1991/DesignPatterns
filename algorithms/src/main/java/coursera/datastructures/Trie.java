package coursera.datastructures;

/**
 * coursera.datastructures.Trie is a data structure that is used to store strings' characters, bits in a tree.
 * This data structure looks as follows
 *
 */
public class Trie
{
    private static final int NO_OF_CHARS = 26;
    private Trie[] children = new Trie[NO_OF_CHARS];
    private int size; // denotes the total length of the characters stores for this node.

    private int getCharIndex(char ch)
    {
        return ch - 'a';
    }

    private Trie getNode(int idx)
    {
        return children[idx];
    }

    public void add(String s)
    {
        add(s, 0);
    }

    /**
     * Adds the given string into the nodes.
     * @param s the string to add
     * @param idx the recursive index
     */
    private void add(String s, int idx)
    {
        size++;
        // if we reached the end
        if (s.length() == idx)
        {
            return;
        }
        else
        {
            // do this for each char of s
            final int charIndex = getCharIndex(s.charAt(idx));
            Trie child = getNode(charIndex);
            if (child == null)
            {
                child = new Trie();
                // add this to the children array
                children[charIndex] = child;
            }
            // add the next character
            child.add(s, idx + 1);
        }
    }

    public int findCount(String s)
    {
        return findCount(s, 0);
    }

    /**
     * Finds the count of the number of substrings in the coursera.datastructures.Trie.
     * @param s the substring to find
     * @param index the recursive index
     * @return the number of substring matches
     */
    private int findCount(String s, int index)
    {
        if (index == s.length()) return size;
        Trie child = getNode(getCharIndex(s.charAt(index)));
        if (child == null) return 0; // no chars found against this node.
        return child.findCount(s, index + 1);
    }

    public static void main(String[] args)
    {
        final Trie trie = new Trie();
        trie.add("gary");
        trie.add("garymiller");
        trie.add("gamer");
        System.out.println(trie.findCount("gary"));
        System.out.println(trie.findCount("gamer"));
    }
}
