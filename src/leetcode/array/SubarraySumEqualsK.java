package leetcode.array;

import java.util.HashMap;
// https://leetcode.com/problems/subarray-sum-equals-k/

// 解題概念: presum + twosum 的解法
// presum 就是 0~i-1 的加總, 我們計算出每個位置的 presum 記錄起來
public class SubarraySumEqualsK {


    public int subarraySum(int[] nums, int k) {
        // Edge cases
        if(nums.length == 0)    return 0;

        // Sliding window -- No, contains negative number
        // hashmap + preSum
        /*
            1. Hashmap<sum[0,i - 1], frequency>
            2. sum[i, j] = sum[0, j] - sum[0, i - 1]    --> sum[0, i - 1] = sum[0, j] - sum[i, j]
                   k           sum      hashmap-key     -->  hashmap-key  =  sum - k
            3. now, we have k and sum.
                  As long as we can find a sum[0, i - 1], we then get a valid subarray
                 which is as long as we have the hashmap-key,  we then get a valid subarray
            4. Why don't map.put(sum[0, i - 1], 1) every time ?
                  if all numbers are positive, this is fine
                  if there exists negative number, there could be preSum frequency > 1
        */
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int result = 0;
        map.put(0, 1); //!!!!
        for(int cur : nums) {
            sum += cur;
            // 因為 sum[0~j] = sum[0~i-1] + sum[i~j] (k)
            // 所以 sum[0~j] - k = sum[0~i-1]

            // 所以 k = 2, sum =2, key = 0
            if(map.containsKey(sum - k))  // there exist a key, that [hashmap-key  =  sum - k]
                result += map.get(sum - k);

            // 放入 frequency(預設1, 但若之前已經有此 key, 要先取出值在+1)
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return result;
    }


    public static void main(String args[]) {
        int[] nums = {1,1,1};
        int k = 2;
        System.out.println(new SubarraySumEqualsK().subarraySum(nums, k));
    }
}
