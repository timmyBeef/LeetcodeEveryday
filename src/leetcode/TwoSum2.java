package leetcode;



/*
https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

use Two Pointers

because it's a sorted array, we can use two pointer to find the ans

left = 0, right = n-1

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.

the ans index is+1

Time complexity : O(n).
Each of the nn elements is visited at most once,
thus the time complexity is O(n).

Space complexity : O(1).
We only use two indexes, the space complexity is O(1).
 */

class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        // Assume input is already sorted.
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                return new int[] { left + 1, right + 1 };
            }
        }
        return new int[]{};
    }

    public static void main(String args[]) {
        int[] test = {2, 7, 11, 15};
        int[] rs = new TwoSum2().twoSum(test, 9);
        System.out.println(rs[0] + "," + rs[1]);
    }
}


