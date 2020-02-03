package leetcode.array.twopointers;

import java.util.Arrays;
/*
    https://leetcode.com/problems/3sum-closest/

    16. 3Sum Closest

Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

Example:

Given array nums = [-1, 2, 1, -4], and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

3 sum 的變種題



 */
public class ThreeSumCloset {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {

                int diff = nums[l] + nums[r] + nums[i] - target;
                if (Math.abs(minDiff) > Math.abs(diff)) {
                    minDiff = diff;
                }

                if (diff == 0) { //這代表找到 三數之和
                    break;
                } else if (diff < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return target + minDiff;

    }

}
