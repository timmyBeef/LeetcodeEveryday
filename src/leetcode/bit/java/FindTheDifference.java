package leetcode.bit.java;
/*
    but this problem's solution only for more one char
 */
public class FindTheDifference {
    public static char findTheDifference(String s, String t) {
        char res = t.charAt(t.length() - 1); // t 多一個, 所以指定最後一位當初始，再去低消 s 長度的
        for (int i = 0; i < s.length(); i++) {
            res ^= s.charAt(i);
            res ^= t.charAt(i);
        }
        return res;
    }

    public static char findTheDifference2(String s, String t) {

        int res = 0;
        for (char c : (s+t).toCharArray()) {
            res ^= (int)c;
        }
        return (char)res;
    }

    public static void main(String[] args) {
        System.out.println(FindTheDifference.findTheDifference2("abc", "abcc"));
    }
}
