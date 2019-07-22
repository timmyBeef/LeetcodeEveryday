package leetcode;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/two-sum/solution/

we want to find two number's indexs

use a map to store every (value, idx),
check (target - now value) is it in map,
if exists: get (now value's index and the map index)


用一個 map 把經過的值存起來, 檢查 (target - 下個值), 是不是存在 map 中了
,一一比對, 存在代表得到答案了, 回傳 index


Time complexity : O(n). We traverse the list containing nn elements only once.
Each look up in the table costs only O(1) time.

Space complexity : O(n). The extra space required depends on the number of
items stored in the hash table, which stores at most nn elements.
*/
class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {

            int x = numbers[i];
            if (map.containsKey(target - x)) {

                return new int[] { map.get(target - x), i  };
            }
            map.put(x, i);
        }
        return new int[]{};
    }

    public static void main(String args[]) {
        int[] test = {2, 7, 11, 15};
        int[] rs = new TwoSum().twoSum(test, 9);
        System.out.println(rs[0]+ "," +rs[1]);
    }
}


