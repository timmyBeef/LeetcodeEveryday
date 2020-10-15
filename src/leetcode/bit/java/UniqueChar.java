package leetcode.bit.java;

public class UniqueChar {
    public static boolean isUniqueChar(String str) {
        if (str.length() > 256) {
            return false;
        }

        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if ((checker & (1 << val)) > 0) { // do & check bit, > 0 means it has duplicate char in str
                return false;
            }
            checker |= (1 << val); // left shift means set bit
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(UniqueChar.isUniqueChar("abc"));
        System.out.println(UniqueChar.isUniqueChar("abcc"));
    }
}
