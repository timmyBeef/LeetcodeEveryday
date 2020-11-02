package leetcode.array.java;
/*
    leetcode 152

    due to the negative num product, so calculate the min value

    time: O(n)
    space: O(1)
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int res = nums[0];
        int max = nums[0];
        int min = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp = max;
            int cur = nums[i];
            max = Math.max(Math.max(max * cur, min * cur), cur);
            min = Math.min(Math.min(temp * cur, min * cur), cur);
            res = Math.max(res, max);
        }
        return res;
    }
}
