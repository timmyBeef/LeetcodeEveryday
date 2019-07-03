package leetcode;

import java.util.Arrays;

public class StrStr {
    public int strStr(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }
        char[] target = haystack.toCharArray();
        for (int i = 0; i < target.length - needle.length() + 1; i++) {
            char[] temp = Arrays.copyOfRange(target, i, i + needle.length());
            String str = new String(temp);
            if (str.equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "TESTTTT";
        String needle = "ES";

        System.out.println("index:" + String.valueOf(new StrStr().strStr(haystack, needle)));

    }
}
