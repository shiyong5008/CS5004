import java.util.Arrays;
import java.util.Stack;

class Solution {
    public String minRemoveToMakeValid(String s) {

        Stack<Character> stk = new Stack<>();
        Stack<Integer> stkIndex = new Stack<>();

        for (int i = 0; i < s.length(); ++i) {

            if (s.charAt(i) == '(') {
                stk.push('(');
                stkIndex.push(i);
            }

            if (s.charAt(i) == ')') {
                if (!stk.isEmpty() && stk.peek() == '(') {
                    stk.pop();
                    stkIndex.pop();
                }
                else {
                    stk.push(')');
                    stkIndex.push(i);
                }
            }
        }

        char[] ch = s.toCharArray();
        char[] remove = new char[s.length() - stk.size()];

        if (stk.isEmpty()) return s;

        int j = s.length() - 1 - stk.size();
        for (int i = s.length() - 1; i >= 0; --i) {
            if (stkIndex.isEmpty() || i != stkIndex.peek()) {
                remove[j] = ch[i];
                --j;
            }
            if (!stkIndex.isEmpty() && i == stkIndex.peek()) {
                stkIndex.pop();
            }
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length() - stk.size(); ++i) {
            res.append(remove[i]);
        }

        return res.toString();

        /*
        Set<Integer> indexesToRemove = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    indexesToRemove.add(i);
                } else {
                    stack.pop();
                }
            }
        }
        // Put any indexes remaining on stack into the set.
        while (!stack.isEmpty()) indexesToRemove.add(stack.pop());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!indexesToRemove.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();

        */

    }

}

