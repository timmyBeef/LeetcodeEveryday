package leetcode.array.java;

import java.util.ArrayList;
import java.util.List;

/*
    leetcode 57
    1. add no intersection
    2. merge intersection
    3. add others

    time: O(n)
    space: O(n)
 */
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int i = 0;
        int len = intervals.length;
        // no intersection, end < new start, do i++
        while (i < len && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i++]);
        }
        while (i < len && intervals[i][0] <= newInterval[1]) { // intersection, start <= new end
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        res.add(newInterval);

        while (i < len) { // add others
            res.add(intervals[i++]);
        }
        return res.toArray(new int[res.size()][]);
    }
}
