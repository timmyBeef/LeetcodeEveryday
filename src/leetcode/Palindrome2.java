package leetcode;

// https://leetcode.com/problems/valid-palindrome-ii/
// use greedy
//O(N) 最多跑 s 長度
//O(1) 只有變數i j
public class Palindrome2 {
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j && s.charAt(i) == s.charAt(j)) {
            i++; j--;
        }

        if (i >= j) return true;

        // 嘗試跳過一個字母, 左跳過 或 右邊跳過
        if (isPalin(s, i + 1, j) || isPalin(s, i, j - 1)) {
            return true;
        }
        return false;
    }

    private boolean isPalin(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++; j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String text = "abca";
        System.out.println("Is this pala:" + String.valueOf(new Palindrome2().validPalindrome(text)));

    }
}
