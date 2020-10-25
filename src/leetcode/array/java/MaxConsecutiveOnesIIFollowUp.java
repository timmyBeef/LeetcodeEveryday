package leetcode.array.java;

import java.util.LinkedList;
import java.util.Queue;

/*
    leetcode 487 follow up

    1 0  1     1    0

    if k = 1

    i = 1, left = 0
    add to q,
    q = 1
    res = 1 - 0 + 1 = 2

    i = 4,
    add to q, q = 2,
    q.size() > k
    left = q.poll() + 1 = 1 + 1 = 2

    res = 4 - 2 + 1 = 3

    time: O(n)
    space: O(n)
 */
public class MaxConsecutiveOnesIIFollowUp {
    public int findMaxConsecutiveOnes(int[] nums, int k) {
        int res = 0;
        int left = 0;
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                queue.offer(i);
            }
            if (queue.size() > k) { // when zero index size > k, pop index, calculate left
                left = queue.poll() + 1;
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}
