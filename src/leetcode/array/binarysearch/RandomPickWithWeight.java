package leetcode.array.binarysearch;

import java.util.Random;
/*
    528. Random Pick with Weight
    https://app.gitbook.com/@timmybeeflin/s/cracking-leetcode/binary-search/528.-random-pick-with-weight

    time: O(n)
    space: O(n)
 */
public class RandomPickWithWeight {
    Random random;
    int sum[];

    public RandomPickWithWeight(int[] w) {
        for (int i = 1; i < w.length; i++) {
            w[i] += w[i - 1];
        }
        sum = w;
        random = new Random();
    }

    public int pickIndex() {
        int index = random.nextInt(sum[sum.length - 1]) + 1;
        int left = 0;
        int right = sum.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;

            if (sum[mid] == index) {
                return mid;
            } else if (sum[mid] < index) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
}
