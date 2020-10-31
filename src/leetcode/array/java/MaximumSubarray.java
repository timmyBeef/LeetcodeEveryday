package leetcode.array.java;

public class MaximumSubarray {
    /*
    [-2,1,-3,4]
    sum: -2
    res: -2

    sum: 1, -2+1 = 1
    res = 1

    sum -3, -3+1 = -2
    res = 1...

    time: O(n)
    space: O(1)
    */
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(nums[i], sum + nums[i]);
            res = Math.max(res, sum);
        }
        return res;
    }

    /*
        dp solution
        time: O(n)
        space: O(n)
     */
    public int maxSubArray2(int[] nums) {
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + (dp[i-1] < 0 ? 0 : dp[i-1]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
