package leetcode;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array/
/*
Time complextiy : O(n).
Assume that n is the length of array. Each of i and j traverses at most n-1 steps.

Space complexity : O(1).
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int i = 1; //應該從1開始填入, 因為index 0, 一定不會是重複的
        for(int j = 0; j < nums.length-1; j++) {
            if(nums[j] != nums[j+1]) { // 一但不重複, 回填

                nums[i] = nums[j+1];
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.print(new RemoveDuplicatesFromSortedArray().removeDuplicates(new int[]{1,1,2}));


    }
}
