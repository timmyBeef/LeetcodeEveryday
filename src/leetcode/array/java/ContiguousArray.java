package leetcode.array.java;

import java.util.HashMap;
import java.util.Map;

/*
leetcode 525
presum + hashMap(presum, idx)

        // 0 1 0 1
        // cont, index) con
        // map(0, -1 (presum, idx)

        // map(-1, 0)
        // i = 1, presum = 0, res = i - map.get(0) = 1 -(-1) = 2
        // i = 2, presum = -1, 2 - map.get(-1) = 2 - 0 = 2
        // i = 3, presum = 0, 3 - map.get(0) = 3 -(-1) = 4

        when 0, presum += -1
        when 1, presum += 1

        presum only has 0 or -1, in hashMap(0, x), hashMap(-1,x)
        so if presum result in 0 or -1, get the len, maxlen

        time: O(n)
        space: O(n)
 */
public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        int presum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // init state, (presum=0, idx = -1)
        int res = 0;

        for (int i = 0 ; i < nums.length ; i++) {
            presum += (nums[i] == 0 ? -1 : 1);
            if (map.containsKey(presum)) {
                res = Math.max(res, i - map.get(presum));
            } else {
                map.put(presum, i);
            }
        }
        return res;
    }
}
