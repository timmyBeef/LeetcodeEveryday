package leetcode.lang.translation;

public class RomanToInteger {

/*
https://leetcode.com/problems/roman-to-integer/

I - 1
V - 5
X - 10
L - 50
C - 100
D - 500
M - 1000

 * If I comes before V or X, subtract 1 eg: IV = 4 and IX = 9
 * If X comes before L or C, subtract 10 eg: XL = 40 and XC = 90
 * If C comes before D or M, subtract 100 eg: CD = 400 and CM = 900


 key point, IV => 4 => I 和 V  => 這種要減的  "後面都比前面大"

 IV = 4 and IX = 9

 I < V, I < X

 XL = 40 and XC = 90

 X < L, X < C

 CD = 400 and CM = 900

 C < D , C < M

O(N)
O(1)
*/
    public int romanToInt(String s) {

        int result = 0;
        if(s == null || "".equals(s)) {
            return result;
        }

        for(int i = 0 ; i < s.length()-1; i++) {
            int cur = getVal(s.charAt(i));
            int next = getVal(s.charAt(i+1));
            if(next > cur) {
                result -= cur;
            } else {
                result += cur;
            }
        }
        result += getVal(s.charAt(s.length()-1)); // add last char

        return result;
    }

    public int getVal(char c) {

        switch (c) {
            case 'M' :  return 1000;
            case 'D' :  return 500;
            case 'C' :  return 100;
            case 'L' :  return 50;
            case 'X' :  return 10;
            case 'V' :  return 5;
            case 'I' :  return 1;
        }
        return 0; // unsupported input
    }

    public static void main(String args[]) {

        String input = "MCMXCIV";
        System.out.println(new RomanToInteger().romanToInt(input));
    }
}
