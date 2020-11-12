package leetcode.array.java;

import java.util.HashMap;
import java.util.Map;

/*
    leetcode 532
    time: O(n)
    space: O(n)

    use hashMap save (num, num's count), create an "unique num map" and count

    when k = 0, find count >= 2 case, res++

    other case, find map.containsKey(mapkey + k) means  "elment - k = another element"

    Input: nums = [3,1,4,1,5], k = 2
    Output: 2
    Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
    Although we have two 1s in the input, we should only return the number of unique pairs.

    hashMap: (num, num's count)
    (3, 1)
    (1, 2)
    (4, 1)
    (5, 1)
    k = 2

    for loop map
    map.containsKey(3 + 2) => true => res++
    map.containsKey(1 + 2) => true => res++
    result is 2

    Input: nums = [1,3,1,5,4], k = 0
    Output: 1
    Explanation: There is one 0-diff pair in the array, (1, 1).

    hashMap: (num, num's count)
    (1, 2)
    (3, 1)
    (5, 1)
    (4, 1)
    k = 0
    for loop map
    k = 0, find count >= 2, only (1, 2) meets, result is 1

 */
public class KDiffPairsInAnArray {
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) return 0;

        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                if (entry.getValue() >= 2) {
                    res++;
                }
            } else {
                if (map.containsKey(entry.getKey() + k)) {
                    res++;
                }
            }
        }
        return res;
    }
}
