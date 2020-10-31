package leetcode.array.java;

import java.util.HashMap;
import java.util.Map;

/*
    leetcode 325

    like 2sum
    1. caculate acc sum
    2. use hashmap to record sum and idx
    3. decide abandon which element, so...
        curr - abandon = k
        abandon = curr - k , find map exists abandon, means find the start idx
    4. i - abandon idx
    5. cant find, record value, idx in map
    (but in order to find max distance, if map has the key before, dont update,
    therefore it'll the smaller idx in map(aka maxinum dis)


    time: O(n)
    space: O(n)
 */
public class MaximumSizeSubarraySumEqualsK {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;

        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i-1];
        }
        // curr - ? = k
        // ? = curr - k (in map)
        for (int i = 0 ; i < nums.length; i++) {
            if (map.containsKey(nums[i] - k)) {
                res = Math.max(res, i - map.get(nums[i] - k));
            }
            if (!map.containsKey(nums[i])) { // for maintaining max distance
                map.put(nums[i], i);
            }
        }
        return res;
    }
}
