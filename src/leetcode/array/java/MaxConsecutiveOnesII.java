package leetcode.array.java;
/*
    leetcode 487

    Using sliding window to solve this

    1 0  1     1    0
         left       i

    for loop {
        if element == 0 {
            1. calculate left boundary: left = zeroIndex + 1
            2. record zero index
        }
        3. calculate result = i - left + 1
    }

    time: O(n)
    space: O(1)
 */
public class MaxConsecutiveOnesII {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int zeroIdx = -1;
        int left = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                left = zeroIdx + 1;
                zeroIdx = i;
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}
