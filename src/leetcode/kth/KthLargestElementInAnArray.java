package leetcode.kth;


// https://leetcode.com/problems/kth-largest-element-in-an-array/

/*
 Kth 用 quick select (看圖解)

 step 1: // Take A[end] as the pivot,
 step 2: // Put numbers < pivot to pivot's left
 step 3: // Finally, swap A[end] with A[left]

 step 4: if (left == k) // Found kth smallest number

         else if (left < k)// Check right part

         else // Check left part
*/

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return Integer.MAX_VALUE;
        return QuickSelectKthSmallest(nums, 0, nums.length - 1, nums.length - k);
    }

    public int QuickSelectKthSmallest(int[] nums, int start, int end, int k) {// quick select: kth smallest
        if (start > end) return Integer.MAX_VALUE;

        int pivot = nums[end];// Take A[end] as the pivot,
        int left = start;
        for (int i = start; i < end; i++) {
            if (nums[i] <= pivot) // Put numbers < pivot to pivot's left
                swap(nums, left++, i);
        }
        swap(nums, left, end);// Finally, swap A[end] with A[left]

        if (left == k)// Found kth smallest number
            return nums[left];
        else if (left < k)// Check right part
            return QuickSelectKthSmallest(nums, left + 1, end, k);
        else // Check left part
            return QuickSelectKthSmallest(nums, start, left - 1, k);
    }

    void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public static void main(String args[]) {
        int input[] = {3, 2, 1, 5, 6, 4};
        int k = 2;

        System.out.println(String.valueOf(new KthLargestElementInAnArray().findKthLargest(input, k)));

    }
}
