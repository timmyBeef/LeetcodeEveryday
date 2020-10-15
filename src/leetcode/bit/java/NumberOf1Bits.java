package leetcode.bit.java;

public class NumberOf1Bits {
    public static int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += n & 1;
            System.out.println("res" + res);
            n >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int r = NumberOf1Bits.hammingWeight(9);
        System.out.println(r);
    }
}
