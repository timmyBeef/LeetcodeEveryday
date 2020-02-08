package leetcode.array.twopointers;

/*
    713. Subarray Product Less Than K
    https://leetcode.com/problems/subarray-product-less-than-k/

Your are given an array of positive integers nums.

Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than k.

Example 1:
Input: nums = [10, 5, 2, 6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
Note:

0 < nums.length <= 50000.
0 < nums[i] < 1000.
0 <= k < 10^6.


    https://leetcode.com/problems/subarray-product-less-than-k/discuss/108861/JavaC%2B%2B-Clean-Code-with-Explanation

The idea is always keep an max-product-window less than K;
Every time shift window by adding a new number on the right(j), if the product is greater than k, then try to reduce numbers on the left(i), until the subarray product fit less than k again, (subarray could be empty);
Each step introduces x new subarrays, where x is the size of the current window (j + 1 - i);

example:
for window (5, 2), when 6 is introduced, it add 3 new subarray: (5, (2, (6)))
        (6)
     (2, 6)
  (5, 2, 6)

 */
public class SubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) return 0; //edge case

        int product = 1;

        int l = 0;
        int count = 0;

        for (int r = 0; r < nums.length; r++) {
            product *= nums[r]; //caculate product

            while (l <= r && product >= k) { // >= k, do l shift,
                product /= nums[l];
                l++;
            }
            count += (r - l + 1); //   number of subarrays
        }
        return count;
    }
}
