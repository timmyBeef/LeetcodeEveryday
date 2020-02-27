package leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    /*
    所有的排列, 不合邏輯的
    public void generateParenthesis(int n) {

        this.gen(1, 2*n, ""); // n=3, 有三個左括號三個右括號
    }
    private void gen(int level, int max, String s) {
        if (level > max) {
            System.out.println(s);
            return;
        }
        gen(level+1, max, s + "(");
        gen(level+1, max, s + ")");

    }
    */

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        gen(0, 0, "", result, n);
        return result;
    }

    private void gen(int left, int right, String s, List<String> result, int n) {
        //termiator
        if (left == n && right == n) { // or if (s.length() == 2*n) {
            result.add(s);
        }
        // drill down
        if (left < n) {
            gen(left + 1, right, s + "(", result, n);
        }
        if (left > right) {
            gen(left, right + 1, s + ")", result, n);
        }
    }


    public static void main(String[] args) {
        GenerateParenthesis test = new GenerateParenthesis();
        System.out.println(test.generateParenthesis(3).toString());
    }
}
