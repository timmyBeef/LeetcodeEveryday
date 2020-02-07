package leetcode.caculate;

import java.util.Arrays;

// https://leetcode.com/problems/move-zeroes/

/*
Input: [0,1,0,3,12]
Output: [1,3,12,0,0]

Input: [1,0,0,3,12]
Output: [1,3,12,0,0]

use swap
pointer lastNonZeroFoundAt point the 0 position

init: lastNonZeroFoundAt = 0

if cur != 0 do swap and lastNonZeroFoundAt++

Time Complexity: O(n).
Space Complexity : O(1). Only constant space is used.

inplace 關鍵 : 2 個指標
lastNonZeroFoundAt 用來指 0 的index, 因為 0 的時候, lastNonZeroFoundAt 不動
cur 目前位置, cur 會一直動, 所以當 cur !=0 時, 做 swap , lastNonZeroFoundAt(0的位置) 和 cur
swap 完, lastNonZeroFoundAt++, 所以 lastNonZeroFoundAt 一直指到0 (因為swap了)
如此一直把 0 swap 到最後面！
 */
public class MoveZeroes {

    //no 1
    public static void moveZeroesTrick(int[] nums) {
        int leftMostZeroIndex = 0; // The index of the leftmost zero
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i > leftMostZeroIndex) { // There are zero(s) on the left side of the current non-zero number, swap!
                    nums[leftMostZeroIndex] = nums[i]; //do swap!! so smart
                    nums[i] = 0;
                }

                leftMostZeroIndex++; // notice this poistion here
            }
        }
    }

    //no 2
    static void moveZeroes(int[] nums) {
        int lastNonZeroFoundAt = 0;
        for (int cur = 0; cur < nums.length; cur++) {
            if (nums[cur] != 0) { // 如果是這樣的資料, Input: [1,0,0,3,12], swap 完, 1還是同個位置
                swap(nums, lastNonZeroFoundAt, cur);
                lastNonZeroFoundAt++;
            }
        }
    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // 把非0的都排到左邊後, 最後補0,簡單多了, 但可能不符合 Minimize the total number of operations.
    // Shift non-zero values as far forward as possible
    // Fill remaining space with zeros
    public static void moveZeroesSimple(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int insertPos = 0;
        for (int num: nums) {
            if (num != 0) nums[insertPos++] = num;
        }

        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }

    // two array
    static void moveZeroesByTwoArray(int[] nums) {
        int lastNonZeroFoundAt = 0;
        // If the current element is not 0, then we need to
        // append it just in front of last non 0 element we found.
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroFoundAt++] = nums[i];
            }
        }
        // After we have finished processing new elements,
        // all the non-zero elements are already at beginning of array.
        // We just need to fill remaining array with 0's.
        for (int i = lastNonZeroFoundAt; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

        public static void main(String args[]) {

            int nums[] = {0,1,0,3,12};
            MoveZeroes.moveZeroesTrick(nums);

            System.out.println(Arrays.toString(nums));


            int nums2[] = {4,0,0,3,12, 0, 0, 4, 5};

            MoveZeroes.moveZeroesTrick(nums2);

            System.out.println(Arrays.toString(nums2));

        }
}
