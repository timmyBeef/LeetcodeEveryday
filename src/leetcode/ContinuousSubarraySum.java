package leetcode;

import java.util.HashMap;
import java.util.Map;

/*
Now, assume that the given sum value at the i-th
  index be equal to remrem. Now, if any subarray follows the i-th
  element, which has a sum equal to the integer multiple of k, say extending upto the j-th
  index, the sum value to be stored in the HashMap for the j-th index
  will be: (rem+n∗k), where n is some integer > 0.
  We can observe that  rem(rem+n∗k), which is the same value as stored corresponding
  to the i-th index..
*/
public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0)
                sum = sum % k; // 紀錄 % 後的 key
            if (map.containsKey(sum)) { // 如果之後又遇到, 代表你和上一個發生 這個% 後的 key, 相差了 k倍 !
                if (i - map.get(sum) > 1) // 所以看一下 index 和上次發生的 index 是不是 比 1 大, 代表中間有隔一個數, 所以是連續的
                    return true;
            } else
                map.put(sum, i);
        }
        return false;
    }

    public boolean checkSubarraySum2(int[] nums, int k) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);

        for(int i=0; i < nums.length;i++) {
            sum += nums[i];
            if(k!=0) {
                sum = sum % k;
            }
            if(map.containsKey(sum)) {
                int mapIndex = map.get(sum);
                if(i - mapIndex > 1) {
                    return true;
                }
            } else {
                map.put(sum, i);
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int[] nums = {23, 2, 4, 6, 7};
        int k = 6;
        System.out.println(new ContinuousSubarraySum().checkSubarraySum2(nums, k));
    }
}