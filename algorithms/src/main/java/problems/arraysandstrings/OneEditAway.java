package problems.arraysandstrings;

public class OneEditAway {

    public static void main(String[] args) {
        String inputs[][] = new String[][]{
                {"apple", "apcle"},
                {"bark", "bark"},
                {"abcba", "abbba"},
                {"pale", "bakes"},
        };
        for (int i = 0; i < inputs.length; i++) {
            System.out.println(isOneEditAway(inputs[i][0], inputs[i][1]));
        }
    }

    private static boolean isOneEditAway(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        if (Math.abs(lenA - lenB) > 1) return false;
        else {
            String shorterString = lenA > lenB ? b : a;
            int sidx = 0;
            int lidx = 0;
            String biggerString = lenB > lenA ? b : a;
            boolean found = false;
            while (sidx < shorterString.length() && lidx < biggerString.length()) {
                if (shorterString.charAt(sidx) != biggerString.charAt(lidx)) {
                    if (found) {
                        return false;
                    }
                    found = true;
                    if (shorterString.length() == biggerString.length()) {
                        sidx++;
                    }
                }
                else {
                    sidx++;
                }
                lidx++;
            }

        }
        return true;
    }
}
