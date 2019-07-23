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
The advantage of this solution is it is very efficient.
The disadvatage of this solution are it is neither an online solution nor a stable one.
And the K elements closest are not sorted in ascending order.
*/

import java.util.PriorityQueue;
import java.util.Random;

public class KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {
        int size = nums.length;
        // kth largest is (N - k)th smallest
        return quickselect(nums, 0, size - 1, size - k);
    }

    public int quickselect(int nums[], int left, int right, int kSmallest) {
    /*
    Returns the k-th smallest element of list within left..right.
    */

        if (left == right) // If the list contains only one element,
            return nums[left];  // return that element

        // select a random pivotIndex
        Random randomNum = new Random();
        int pivotIndex = left + randomNum.nextInt(right - left);

        pivotIndex = partition(nums, left, right, pivotIndex);

        // the pivot is on (N - k)th smallest position
        if (kSmallest == pivotIndex) {
            return nums[kSmallest];

            // go left side
        } else if (kSmallest < pivotIndex) {
            return quickselect(nums, left, pivotIndex - 1, kSmallest);

        } else {
            // go right side
            return quickselect(nums, pivotIndex + 1, right, kSmallest);
        }
    }

    public int partition(int nums[], int left, int right, int pivotIndex) {
        int pivot = nums[pivotIndex];

        // 1. move pivot to end
        swap(nums, pivotIndex, right);
        int storeIndex = left;

        // 2. move all smaller elements to the left
        for (int i = left; i <= right; i++) {
            if (nums[i] < pivot) {
                swap(nums, storeIndex, i);
                storeIndex++;
            }
        }

        // 3. move pivot to its final place
        swap(nums, storeIndex, right);

        return storeIndex;
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

    /*
        The advantage of this solution is it can deal with real-time(online)
        stream data. It does not have to know the size of the data previously.
        The disadvatage of this solution is it is not the most efficient solution.

        The idea is to init a heap "the smallest element first",
        and add all elements from the array into this heap one by one keeping
        the size of the heap always less or equal to k. That would results
        in a heap containing k largest elements of the array.

        The head of this heap is the answer, i.e. the kth largest element of the array.

        Time complexity : O(Nlogk).
        Space complexity : O(k) to store the heap elements.

     */
    public int findKthLargestByHeap(int[] nums, int k) {
        // init heap 'the smallest element first'
        PriorityQueue<Integer> heap =
                new PriorityQueue<Integer>((n1, n2) -> n1 - n2);

        // keep k largest elements in the heap
        for (int n : nums) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        // output
        return heap.poll();
    }
}
