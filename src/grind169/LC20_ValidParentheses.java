package grind169;

import java.util.Stack;

public class LC20_ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[' || c == '(' || c == '{') {
                stack.push(c);
            } else {
                if (c == ']' && (!stack.isEmpty() && stack.peek() == '[')) {
                    stack.pop();
                } else if (c == '}' && (!stack.isEmpty() && stack.peek() == '{')) {
                    stack.pop();
                } else if (c == ')' && (!stack.isEmpty() && stack.peek() == '(')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        LC20_ValidParentheses test = new LC20_ValidParentheses();
        boolean flag = test.isValid("()[]{}");
        System.out.println(flag);
        System.out.println(test.isValid("([])"));
        System.out.println(test.isValid("([)]"));
    }
}
