package leetcode.array.twopointers;

// 986. Interval List Intersections
// https://leetcode.com/problems/interval-list-intersections/

/*



step1: two pointer from zero

intersection: A's end > B's start, so get the max start, and the min end



// 要移掉 A 和 B 之間較小的 end, 因為只能和之前的做 intersect, 如此地去移動 porinter
If A[0] has the smallest endpoint, it can only intersect B[0].
After, we can discard A[0] since it cannot intersect anything else.

Similarly, if B[0] has the smallest endpoint, it can only intersect A[0],
and we can discard B[0] after since it cannot intersect anything else.

Time Complexity: O(M+N), where M,N are the lengths of A and B respectively.

Space Complexity: O(M+N), the maximum size of the answer.

 */

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> ans = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < A.length && j < B.length) {
            // Let's check if A[i] intersects B[j].
            // startMax - the startpoint of the intersection
            // endMin - the endpoint of the intersection
            int startMax = Math.max(A[i][0], B[j][0]); //start
            int endMin = Math.min(A[i][1], B[j][1]); //end
            if (startMax <= endMin) {
                ans.add(new int[]{startMax, endMin});
            }

            // Remove the interval with the smallest endpoint, 比較小的 end , 要移動到下組資料
            if (A[i][1] < B[j][1]) {
                i++;
            } else {
                j++;
            }

        }

        return ans.toArray(new int[ans.size()][]);
    }

}
