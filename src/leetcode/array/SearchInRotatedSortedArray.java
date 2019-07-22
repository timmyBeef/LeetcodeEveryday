package leetcode.array;

//https://leetcode.com/problems/search-in-rotated-sorted-array/

/*
error:2

Binary search: the condition is in sorted array

find the part is still in sorted order.

The idea is that when rotating the array, there must be one half of the array that is
still in sorted order.
For example, 6 7 1 2 3 4 5, the order is disrupted from the point between 7 and 1.

So when doing binary search, we can make a judgement that which part is ordered and
whether the target is in that range, if yes, continue the search in that half,
if not, continue in the other half.

Time complexity : O(log(N)).
Space complexity : O(1).

*/
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {  //because it will match...!!
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;

            } else if (nums[start] <= nums[mid]) { //!! left part
                // make a judgement that which part is ordered and
                // whether the target is in that range
                if (target <= nums[mid] && target >= nums[start]) //in left part so end = mid-1 !!!
                    end = mid - 1; //opposite outer
                else
                    start = mid + 1;
            } else { //!! right part
                // make a judgement that which part is ordered and
                // whether the target is in that range
                if (target >= nums[mid] && target <= nums[end]) //in right part so start = mid+1
                    start = mid + 1; //opposite outer
                else
                    end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        int nums[] = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;

        System.out.println(new SearchInRotatedSortedArray().search(nums, target));
    }
}
