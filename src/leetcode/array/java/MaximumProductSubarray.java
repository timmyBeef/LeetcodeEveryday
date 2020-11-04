package leetcode.array.java;
/*
    leetcode 152

    due to the negative num product may gen max number, so calculate the min value

    -1*-12 = 12

    [2,3,-2,4]
    max = 2, min = 2, res = 2

    i=1
    max = 6, min = 3, res = 6
    i=2
    max = -2, min = -12, res = 6
    i=3
    max = 4, min = -48, res = 6

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
