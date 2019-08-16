package coursera.datastructures.week1;

import java.util.Stack;

class Bracket {
    char type;
    int position;

    Bracket(char type, int position) {
        this.type = type;
        this.position = position;
    }

    boolean Match(char c) {
        if (this.type == '[' && c == ']')
            return true;
        if (this.type == '{' && c == '}')
            return true;
        return this.type == '(' && c == ')';
    }

    static class BracketInterface {
        public static String isOk(String text) {
            Stack<Bracket> opening_brackets_stack = new Stack<>();
            Bracket lonelyBracket = null;
            for (int position = 0; position < text.length(); ++position) {
                char next = text.charAt(position);

                if (next == '(' || next == '[' || next == '{') {
                    // Process opening bracket, write your code here
                    opening_brackets_stack.push(new Bracket(next, position));
                }

                if (next == ')' || next == ']' || next == '}') {
                    // Process closing bracket, write your code here
                    if (opening_brackets_stack.isEmpty() || !(opening_brackets_stack.pop()).Match(next)) {
                        lonelyBracket = new Bracket(next, position);
                        break;
                    }
                }
            }
            if (!opening_brackets_stack.isEmpty()) {
                // lonely bracket is in the stack
                if (lonelyBracket == null) {
                    return String.valueOf(opening_brackets_stack.pop().position + 1);
                }
                // return the lonely bracket's position
                return String.valueOf(lonelyBracket.position + 1);
            }
            else {
                // empty stack
                if (lonelyBracket == null) {
                    return "Success";
                }
                return String.valueOf(lonelyBracket.position + 1);
            }
        }
    }
}
