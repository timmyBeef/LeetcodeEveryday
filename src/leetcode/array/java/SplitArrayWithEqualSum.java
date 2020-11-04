package leetcode.array.java;

/*
    time: O(n^2)
    space: O(n)

    1. cal presum
    2. draw split line
        //    i   j   k
        // [1,2,1,2,1,2,1]
    3. find boundary
    4. calculate equals, and use hashset to record(i, j), for following comparison(j, k)
 */
import java.util.HashSet;
import java.util.Set;

public class SplitArrayWithEqualSum {
    public boolean splitArray(int[] nums) {
        //    i   j   k
        // [1,2,1,2,1,2,1]
        if (nums.length < 7) return false;

        int sum[] = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i-1] + nums[i];
        }

        for (int j = 3; j < nums.length - 3; j++) {
            Set<Integer> set = new HashSet<>();
            for (int i = 1; i < j - 1; i++) {
                if (sum[i-1] == sum[j-1] - sum[i]) {
                    set.add(sum[i-1]);
                }
            }
            for (int k = j +2 ; k < nums.length - 1; k++) {
                if (sum[nums.length - 1] - sum[k] == sum[k-1] - sum[j]
                        && set.contains(sum[k-1] - sum[j])) {
                    return true;
                }
            }
        }
        return false;
    }
}
