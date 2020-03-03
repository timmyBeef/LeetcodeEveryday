package leetcode.array.binarysearch;

/*
    time complexity: O(logn), space complexity: O(1)
*/
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) return 0;
        int left = 0;
        int right = length;

        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] < target) {// means in right
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

}
