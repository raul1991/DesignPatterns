package streams.domainobjects;

public class Result
{
    public static int shortestSubstring(String s) {
        int[] map = new int[26];
        // Write your code here
        int distinctChars = getDistinctCharCount(s, map);
        int[] matched = new int[26];
        int step = 0;
        for (int i = 0, l = s.length(); i+step < l;) {
            int charIdx = s.charAt(i + step) - 'a';
            if (i + step < l && (map[charIdx] > 0 && matched[charIdx] == 0)) {
                matched[charIdx] = 1;
                step++;
                if (step == distinctChars) break;
            } else {
                matched = new int[26];
                i++;
                step = 0;
            }
        }
        return step;
    }

    private static int getDistinctCharCount(String s, int[] map)
    {
        int distinctChars = 0;
        for(int i =0; i<s.length(); i++) {
            int charIdx = s.charAt(i) - 'a';
            if (map[charIdx] == 0) ++distinctChars;
            ++map[charIdx];
        }
//        printArray(map);
        return distinctChars;
    }

    private static void printArray(int[] map)
    {
        for (int i = 0; i < map.length; i++)
        {
            System.out.print(map[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        System.out.println(shortestSubstring("babcdefgh"));
        System.out.println(shortestSubstring("bab"));
        System.out.println(shortestSubstring("b"));
        System.out.println(shortestSubstring("addacbbbcad"));
    }
}
