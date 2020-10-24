package leetcode.array.java;
/*
    time: O(n)
    space: O(1)
 */
public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length <= 2) return nums.length;

        int count = 2; // allow two duplicate, so begin at length 2
        for (int i = 2; i < nums.length; i++) {

            // count is the new array insert point,
            // so we should compare index [count - 2] with [i]
            // not equals, insert the value and increase count,
            // the same in leetcode 26, it can write in (count - 1) compare with i
            if (nums[count - 2] != nums[i]) {
                nums[count++] = nums[i];
            }
        }
        return count;
    }
}
