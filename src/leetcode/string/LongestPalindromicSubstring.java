package leetcode.string;

/*
    time: O(n^2)
    space: O(1)

    spread from center

    helper(s, i , i); // for odd case
    helper(s, i, i + 1); // for even case

    for examle:
    b a b a d, spread from middle b , is the helper(s, 2 , 2) case,
    so test each conditions and find the longest palindromic substring
 */
public class LongestPalindromicSubstring {
    String res = "";
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return res;

        for (int i = 0; i < s.length(); i++) {
            System.out.println("\n\n====i==i===");
            helper(s, i , i);
            System.out.println("\n\n====i==i+1===");
            helper(s, i, i + 1);

        }
        return res;
    }

    private void helper(String s, int left, int right) {
        System.out.println("call helper left:" + left + ",right:" + right);

        // do 擴散
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        System.out.println("left+1:" + (left + 1) + ",right:" + right);
        String cur = s.substring(left + 1, right);
        System.out.println("cur:" + cur);
        if (cur.length() > res.length()) {
            System.out.println("res:" + cur);
            res = cur;
        }
    }

    public static void main(String[] args) {
        new LongestPalindromicSubstring().longestPalindrome("babad");
    }
}
