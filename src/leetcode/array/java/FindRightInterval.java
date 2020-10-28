package leetcode.array.java;

import java.util.TreeMap;

/*
    O(nlogn)
    O(n)
 */
public class FindRightInterval {
    public int[] findRightInterval(int[][] intervals) {
        int[] res = new int[intervals.length];
        TreeMap<Integer, Integer> map = new TreeMap<>();// sort(start) + hashmap(start and idx)

        for (int i = 0; i < intervals.length;i++) {
            map.put(intervals[i][0], i);
        }
        for (int i = 0; i < intervals.length;i++) {
            Integer key = map.ceilingKey(intervals[i][1]); // ceilingKey will find >= input
            res[i] = (key == null ? -1 : map.get(key));
        }
        return res;
    }
}
