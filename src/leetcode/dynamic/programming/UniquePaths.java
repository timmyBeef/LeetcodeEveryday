package leetcode.dynamic.programming;

import java.util.Arrays;
/*
    leetcode 62. Unique Paths
    https://leetcode.com/problems/unique-paths/
    O(mn), O(n)
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }

}
