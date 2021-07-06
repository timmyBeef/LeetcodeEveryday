package leetcode.dynamic.programming;
/*
    70. Climbing Stairs
    time: O(n)
    space: O(n),  best: O(1)
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // use fib
    /*
        time: O(n)
        space: O(1)
     */
    class Solution {
        public int climbStairs(int n) {
            if (n == 1) return 1;
            int first = 1;
            int second = 2;

            for (int i = 3; i <= n ; i++) {
                int third = first + second;
                first = second;
                second = third;
            }
            return second;
        }
    }
}
