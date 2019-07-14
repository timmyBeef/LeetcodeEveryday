package leetcode.intervals;


import java.util.*;

// https://leetcode.com/problems/merge-intervals/
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

    public int[][] merge2(int[][] intervals) {
        int len = intervals.length;
        if(len <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        List<int[]> result = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int[] interval : intervals) {
            if(end >= interval[0]) {
                end = Math.max(end, interval[1]);
            } else {
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

        int rs[][] = new MergeIntervals().merge2(vArray);

        Arrays.stream(rs).forEach(r -> System.out.print(Arrays.toString(r)));

    }
}
