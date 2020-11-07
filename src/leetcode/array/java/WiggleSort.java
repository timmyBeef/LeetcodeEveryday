package leetcode.array.java;

/*
   time: O(n)
   space: O(1)
 */
public class WiggleSort {
    public void wiggleSort(int[] nums) {
        // odd high, even low
        for (int i = 1; i < nums.length; i++) {
            if (i % 2 == 1 && nums[i] < nums[i-1] || i % 2 == 0 && nums[i] > nums[i-1]) {
                int temp = nums[i];
                nums[i] = nums[i-1];
                nums[i-1] = temp;
            }
        }
    }
}
