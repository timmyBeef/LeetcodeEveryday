package leetcode.array;
/*
509. Fibonacci Number

https://leetcode.com/problems/fibonacci-number/

https://leetcode.com/problems/fibonacci-number/discuss/215992/Java-Solutions
 */
public class FibonacciNumber {

    /*
        Time complexity: O(n)
        Space complexity: O(1)
     */
    public int fib(int N) {
        if (N <= 1) {
            return N;
        }

        int a = 0;
        int b = 1;
        while (N-- > 1) {
            int sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    /*
        Solution 4: Dynamic Programming - Bottom Up Approach

        Time complexity: O(n)
        Space complexity: O(n)
     */
    public int fibMine(int N) {
        if (N < 0) throw new IllegalArgumentException();
        if (N == 0) return 0;
        if (N == 1) return 1;

        int fib[] = new int[N+1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= N; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }
        return fib[N];
    }
}
