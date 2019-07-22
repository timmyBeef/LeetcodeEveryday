package leetcode.intervals;


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
Other than the sort invocation, we do a simple linear scan of the list,
so the runtime is dominated by the O(nlgn) complexity of sorting.

Space complexity : O(1) (or O(n))
If we can sort intervals in place, we do not need more than constant additional space.
Otherwise, we must allocate linear space to store a copy of intervals and sort that.
 */

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        int length = intervals.length;
        if (length <= 1)
            return intervals;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        List<int[]> result = new ArrayList<>();

        int[] first = intervals[0];
        int start = first[0];
        int end = first[1];

        // 跑所有, 重點是要更新 end
        for(int[] interval : intervals){
            if(end >= interval[0]){ // end > now start
                end = Math.max(interval[1], end); // 取最大的 end
            }else {
                result.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            }
        }

        result.add(new int[]{start, end});

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {

        int vArray[][] = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

        int rs[][] = new MergeIntervals().merge(vArray);

        Arrays.stream(rs).forEach(r -> System.out.print(Arrays.toString(r)));

    }
}
