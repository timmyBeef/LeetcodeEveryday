package leetcode.array.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    time: O(m+n), m: list1 size, n: list2 size
    space: O(m)

    use hashmap store list1, (string, index), then loop list2
    notice when sum == min, they are all results
    when sum < min, clear result & update min
 */
public class MinimumIndexSumOfTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        List<String> res = new ArrayList<>();

        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
            Integer j = map.get(list2[i]);

            if (j != null && i + j <= min) {
                if (i + j < min) {
                    res.clear();
                    min = i + j;
                }
                res.add(list2[i]);
            }
        }
        return res.toArray(new String[res.size()]);
    }
}
