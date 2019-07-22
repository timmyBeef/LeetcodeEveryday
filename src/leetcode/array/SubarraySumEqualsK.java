package leetcode;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    // https://leetcode.com/problems/subarray-sum-equals-k/

/*
use hashmap
presum + twosum 的解法
presum 就是 0~i-1 的加總, 我們計算出每個位置的 presum 記錄起來

1. record Hashmap<presum, frequency>, put(0, 1) as a initial map

2. now sum = presum (base) + k(continuous subarray add) => sum-k = presum means success

4. Why don't map.put(sum[0, i - 1], 1) every time ?
      if all numbers are positive, this is fine
      if there exists negative number, there could be preSum frequency > 1

      [1,1,1]=>  (0,1), (1,1) (2,1) (3, 1)

      目前 sum = presum + k, so sum - k = presum 成立的話, then get a valid subarray ,count++
      連續＋了k, 所以如果之前 presum 有記錄到起始點的 presum, 代表成功

Time complexity : O(n). The entire nums array is traversed only once.

Space complexity : O(n). Hashmap map can contain upto n distinct entries in the worst case.

presum.put 要一直更新

*/
    public int subarraySum(int[] nums, int k) {
        // Edge cases
        if(nums.length == 0)    return 0;

        HashMap<Integer, Integer> presum = new HashMap<>();
        int sum = 0;
        int result = 0;
        presum.put(0, 1); //!!!! presum = 0
        for(int cur : nums) {
            sum += cur;
            // 因為 sum[0~j] = sum[0~i-1] + sum[i~j] (k)
            // 所以 sum[0~j] - k = sum[0~i-1]

            // 所以 k = 2, sum =2, key = 0
            if(presum.containsKey(sum - k)) {  // there exist a key, that [hashmap-key  =  sum - k]
                result += presum.get(sum - k);
            }
            // 放入 frequency(預設1, 但若之前已經有此 key, 要先取出值在+1)
            presum.put(sum, presum.getOrDefault(sum, 0) + 1); //!!
        }
        return result;
    }


    public static void main(String args[]) {
        int[] nums = {1, -1,1,1};
        int k = 2;
        System.out.println(new SubarraySumEqualsK().subarraySum(nums, k));
    }
}
