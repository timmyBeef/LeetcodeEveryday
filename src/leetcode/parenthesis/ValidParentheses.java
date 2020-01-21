package leetcode;

// https://leetcode.com/problems/valid-parentheses/

import java.util.HashMap;
import java.util.Stack;

// use stack, 可看 SOLUTION 最下面的圖解

// in valid case, the left one should appear first,
// so when i encouter a right parentheses, the stack must have a left parentheses in it
// or it an unvalid parenthesis

// At last, if it's valid, the stack is empty

/*
Time complexity : O(n)
because we simply traverse the given string one character at a time and push and pop
operations on a stack take O(1)O(1) time.

Space complexity : O(n) as we push all opening brackets onto the stack and in the worst case,
we will end up pushing all the brackets onto the stack. e.g. ((((((((((.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

    public static void main(String args[]) {
        String input1 = "([)]";
        String input2 = "()[]{}";

        System.out.println(new ValidParentheses().isValid(input1));
        System.out.println(new ValidParentheses().isValid(input2));

    }
}

