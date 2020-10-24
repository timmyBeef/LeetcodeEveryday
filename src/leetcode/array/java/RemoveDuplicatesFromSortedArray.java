package leetcode.array.java;

/*
leetcode 26
https://leetcode.com/problems/remove-duplicates-from-sorted-array/

Time complextiy : O(n).
Assume that n is the length of array. Each of i and j traverses at most n-1 steps.

Space complexity : O(1).
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int count = 1; // 應該從1開始填入, 因為index 0, 一定不會是重複的
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] != nums[i]) { // 不重複, 加入
                nums[count++] = nums[i];
            }
        }
        return count;
    }

    // harder one
    /*
        遇到不一樣的時候, 取代自己目前下個位置的值
        1,1,2  =>  1,2
        1,2 => 1,2
     */
    public static int removeDuplicates2(int[] nums) {
        int size = 0;
        if (nums == null) return size;

        for (int num : nums) {
            if (nums[size] != num) {
                nums[++size] = num;
            }
        }

        return size + 1;
    }

}
