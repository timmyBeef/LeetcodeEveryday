package leetcode;

// https://leetcode.com/problems/valid-parentheses/

import java.util.HashMap;
import java.util.Stack;

// use stack, 可看 SOLUTION 最下面的圖解
/*
Time complexity : O(n)
because we simply traverse the given string one character at a time and push and pop
operations on a stack take O(1)O(1) time.

Space complexity : O(n) as we push all opening brackets onto the stack and in the worst case,
we will end up pushing all the brackets onto the stack. e.g. ((((((((((.
 */
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
                stack.push(c); //push value（左符號）, 用key檢查（右符號）, 因為不可能是 右開頭 這樣必錯
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

