import java.util.Stack;

class Solution {
    public boolean isValid(String s) {

        Stack<Character> stk = new Stack<>();

        int n = s.length();

        // for (int i = 0; i < n; i++) {

        for (char ch : s.toCharArray()) {

            // char ch = s.charAt(i);

            if (stk.isEmpty()) {
                stk.push(ch);
            } else {
                if (pair(ch) == stk.peek()) {
                    stk.pop();
                } else {
                    stk.push(ch);
                }
            }
        }
        return stk.isEmpty();
    }

    public char pair(char x) {
        if (x == ')') {
            return '(';
        }else if (x == ']') {
            return '[';
        }else if (x == '}') {
            return '{';
        }else {
            return 'x';
        }
    }

}
