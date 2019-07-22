package leetcode.caculate;

//https://leetcode.com/problems/string-to-integer-atoi/
/*

    this problem check a lots

    from left scan

    all check i < n
    check white
    check sign
    check is digit

    loop
    check overflow, overflow return  sign ? max : min value
    final: num = num * 10 + digit;
    i++

    return sign * num

    核心概念: 空白不處理, 檢查sign, 檢查 overflow,
    由左開始掃文字, 在 while 迴圈裡結果*10 + 目前數字

    O(N)
    O(1)
 */
public class Atoi {


    private static final int maxDiv10 = Integer.MAX_VALUE / 10;

    public int atoi(String str) {
        int i = 0;
        int n = str.length();

        //all check i < n
        // check white
        while (i < n && Character.isWhitespace(str.charAt(i))) i++;
        // check sign
        int sign = 1;
        if (i < n && str.charAt(i) == '+') {
            i++;
        } else if (i < n && str.charAt(i) == '-') {
            sign = -1;
            i++;
        }

        int num = 0;
        // check is digit
        while (i < n && Character.isDigit(str.charAt(i))) {

            int digit = Character.getNumericValue(str.charAt(i));

            // check overflow
            // MAX_VALUE is 2147483647,
            // the last num is 7
            // in next step we will mutilply 10,
            // so when
            // num > MAX_VALUE/10 or
            // num = MAX_VALUE/10, but next digit >= 8 will overflow
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
