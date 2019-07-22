package leetcode.parenthesis;

//https://leetcode.com/problems/valid-parenthesis-string/solution/


import java.util.Stack;

/*
    greedy - 目的做到 balanced

    step1: When checking whether the string is valid, we only cared about the "balance":

    step2: 創兩個 stack, stack存 idx, 拿來放 left和star, 遇到 right 做抵銷

    right 抵銷時 , 如果 left star都空的 一定是錯的

    step3: 迴圈完, left star都還有的話, 都要pop, 若 pop出的index left比star大, 一定錯

     * ( ( * => 會發現 left一定是先出現的

     最後, left是空的話 ,成功, star 不用理他（可以當空的）
 */

/*
Time complexity : O(n)
because we simply traverse the given string one character at a time and push and pop
operations on a stack take O(1) time.

Space complexity : O(n) as we push all opening brackets onto the stack and in the worst case,
we will end up pushing all the brackets onto the stack. e.g. ((((((((((.
 */
public class ValidParenthesisString {
    public boolean checkValidString(String s) {
        Stack<Integer> leftID = new Stack<>();
        Stack<Integer> starID = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                leftID.push(i);

            } else if (ch == '*') {
                starID.push(i);

            } else { // 右括號時,
                if (leftID.isEmpty() && starID.isEmpty()) { // 都空的 一定是錯的
                    return false;
                }

                // pop 左stack 或 star stack
                if (!leftID.isEmpty()) {
                    leftID.pop();
                } else {
                    starID.pop();
                }
            }
        }

        // 還有剩下的, 要pop完, 但如果 left index > star index 就是錯的, 因為 ＊（ => 無法抵銷
        // * ( ( * => 會發現 left一定是先出現的

        // Note that the left bracket CANNOT appear after the star as there is
        // NO way to balance the bracket. In other words, whenever there is a
        // left bracket index appears after the Last star, a false statement can be made.

        while (!leftID.isEmpty() && !starID.isEmpty()) {
            if (leftID.pop() > starID.pop())
                return false;
        }

        // left 空了就完成！ star 不用理他（可以當空的）
        return leftID.isEmpty();
    }


    public static void main(String args[]) {
        String input = "(***)";
        System.out.println(new ValidParenthesisString().checkValidString(input));
    }
}
