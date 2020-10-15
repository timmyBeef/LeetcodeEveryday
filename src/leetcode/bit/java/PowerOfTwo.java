package leetcode.bit.java;

public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        return (n > 0) && ((n & (n - 1)) == 0); // notice (n & (n - 1))  => (  )
    }
}
