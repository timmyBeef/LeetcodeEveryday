package leetcode.array.twopointers;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array/
/*
Time complextiy : O(n).
Assume that n is the length of array. Each of i and j traverses at most n-1 steps.

Space complexity : O(1).
 */
public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        int i = 1; //應該從1開始填入, 因為index 0, 一定不會是重複的
        for (int j = 0; j < nums.length - 1; j++) {
            if (nums[j] != nums[j + 1]) { // 一但不重複, 回填
                nums[i] = nums[j + 1];
                i++;
            }
        }
        return i;
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

    public static void main(String[] args) {
        System.out.println(RemoveDuplicatesFromSortedArray.removeDuplicates(new int[]{1, 1, 2}) == 2);

        System.out.println(RemoveDuplicatesFromSortedArray.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}) == 5);

    }
}
