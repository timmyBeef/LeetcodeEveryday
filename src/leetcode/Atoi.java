package leetcode;

public class Atoi {
    // 核心概念: 空白不處理, 檢查sign, 檢查 overflow, 由左開始掃文字, 在 while 迴圈裡結果*10 + 目前數字

    private static final int maxDiv10 = Integer.MAX_VALUE / 10;
    public int atoi(String str) {
        int i = 0, n = str.length();

        // check sign
        while (i < n && Character.isWhitespace(str.charAt(i))) i++;
        int sign = 1;
        if (i < n && str.charAt(i) == '+') {
            i++;
        } else if (i < n && str.charAt(i) == '-') {
            sign = -1;
            i++;
        }
        int num = 0;
        while (i < n && Character.isDigit(str.charAt(i))) {
            int digit = Character.getNumericValue(str.charAt(i));

            // check overflow
            if (num > maxDiv10 || num == maxDiv10 && digit >= 8) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            num = num * 10 + digit;
            i++;
        }
        return sign * num;
    }

    public static void main(String[] args) {
        String text = "555553";
        System.out.println(String.valueOf(new Atoi().atoi(text)));

    }
}
