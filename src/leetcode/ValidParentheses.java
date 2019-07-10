package leetcode;

// https://leetcode.com/problems/valid-parentheses/

import java.util.HashMap;
import java.util.Stack;

// use stack, 可看 SOLUTION 最下面的圖解
public class ValidParentheses {
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length() ; i++) {
            char c = s.charAt(i);

            if(map.containsKey(c)) {
                char topElement = stack.empty() ? '#' : stack.pop(); //!!!

                if(topElement != map.get(c)) { //!
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty(); //!!
    }

    public static void main(String args[]) {
        String input1 = "([)]";
        String input2 = "()[]{}";

        System.out.println(new ValidParentheses().isValid(input1));
        System.out.println(new ValidParentheses().isValid(input2));

    }
}

