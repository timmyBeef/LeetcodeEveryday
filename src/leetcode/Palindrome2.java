package leetcode;

// https://leetcode.com/problems/valid-palindrome-ii/
/*

you may delete at most one character. to make it palindrome

The string will only contain lowercase characters a-z.
The maximum length of the string is 50000.

 approach 1: Brute Force [Time Limit Exceeded]
 delete every char to try, the test it, is it palindrome

 approach 2: greedy

 left = 0, right = len -1;

 check one by one by equals, to move the position until error position(not equal)

 // greedy
 if( try to ignore left char to run    or
     try to ignore right char to run ) {
    return true;
 }

 return false;

Time Complexity: O(N) where N is the length of the string.
Each of two checks of whether some substring is a palindrome is O(N).

Space Complexity: O(1) additional complexity. Only pointers were stored in memory.

 */

public class Palindrome2 {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right && s.charAt(left) == s.charAt(right)) {
            left++;
            right--;
        }

        //if (left >= right) return true;

        // 嘗試跳過一個字母, 左跳過 或 右邊跳過
        return isPalin(s, left+1, right) || isPalin(s, left, right-1);

    }

    private boolean isPalin(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String text = "abca";
        System.out.println("Is this pala:" + String.valueOf(new Palindrome2().validPalindrome(text)));

    }
}
