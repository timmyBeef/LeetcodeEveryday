package leetcode.array.java;


import java.util.*;

// https://leetcode.com/problems/merge-intervals/
// https://leetcode.wang/leetCode-56-Merge-Intervals.html 解法 2 圖解

/*
    step1: if (length <= 1) return intervals;
    step2: sort start first

    step3: merge:
    {
        if new one is coming,
             new one's start <= pre's end (overlap), update pre one's end to new end

        else
            add to result
            update start, end

    }
    add to result

Time complexity : O(nlogn)
Space complexity : O(1) (or O(n))

If we can sort intervals in place, we do not need more than constant additional space.
Otherwise, we must allocate linear space to store a copy of intervals and sort that.
 */

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0
                || intervals[0] == null || intervals[0].length == 0) return intervals;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]); // remember to sort first

        List<int[]> res = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int interval[] : intervals) {
            if (end >= interval[0]) { // intersection
                end = Math.max(end, interval[1]);
            } else { // no intersection
                res.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            }
        }
        res.add(new int[]{start, end}); // for loop maybe end at if statement, so we should add the last result

        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {

        int vArray[][] = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

        int rs[][] = new MergeIntervals().merge(vArray);

        Arrays.stream(rs).forEach(r -> System.out.print(Arrays.toString(r)));

    }
}
