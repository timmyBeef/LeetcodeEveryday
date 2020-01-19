package leetcode;

import java.util.*;

/*Welcome to Facebook!

This is just a simple shared plaintext pad, with no execution capabilities.

When you know what language you would like to use for your interview,
simply choose it from the dropdown in the top bar.

Enjoy your interview!
* /

/*
Given an array of integers, return the position of the maximum element.
If the maximum element occurs multiple times,
use a random number generator to choose one of the positions uniformly at random.


Example:
[3, 1, 3, 2, 1]
Largest element is 3
Occurs at indices 0, and 2
Return 0 1/2 the time; and 2 1/2 the time

time complexity: O(N)
[-2, -1, -3, -4]
*/
public class FbInterviews {

    public int findMaximum(int nums[]) {
        if (nums.length == 0) return -1;

        int max = Integer.MIN_VALUE;
        // find maximum
        for (int num : nums) {

            max = Math.max(max, num);

        }

        int result[] = new int[nums.length];
        int j = 0;
        // find the index of maximum
        for (int i = 0; i < nums.length; i++) {
            if (max == nums[i]) {
                result[j] = i; //space O(K),  K = result SIZE K < N
                j++;
            }
        }

        Random random = new Random();
        int randomindex = random.nextInt(j);
        return result[randomindex];

    }

    public static void main(String args[]) {

        int nums[] = {3, 1, 3, 2, 1};

        int nums2[] = {-2, -1, -3, -4};
        System.out.println(new FbInterviews().findMaximum(nums));

        System.out.println(new FbInterviews().findMaximum(nums2));

    }
}

