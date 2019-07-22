package leetcode.array;


// https://leetcode.com/problems/monotonic-array/

//O(N) where N is the length of A.
//O(1)

public class MonotonicArray {

    // two pass
    public boolean isMonotonic(int[] A) {

        return asc(A) || desc(A);
    }

    private boolean asc(int A[]) {
        int i = 0;
        while (i < A.length - 1) {
            if (A[i] > A[i + 1]) {
                return false;
            }
            i++;
        }
        return true;

    }

    private boolean desc(int[] A) {
        int j = 0;
        while (j < A.length - 1) {

            if (A[j] < A[j + 1]) {
                return false;
            }
            j++;
        }
        return true;
    }

    // one pass
    public boolean isMonotonicByOnePass(int[] A) {
        boolean increasing = true;
        boolean decreasing = true;
        for (int i = 0; i < A.length - 1; ++i) {
            if (A[i] > A[i+1])
                increasing = false;
            if (A[i] < A[i+1])
                decreasing = false;
        }

        return increasing || decreasing;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 3};
        int[] nums2 = {6, 5, 4, 4};
        int[] nums3 = {1, 3, 2};
        int[] nums4 = {1, 2, 4, 5};
        int[] nums5 = {1, 1, 1};

        System.out.println("isMonotonic1:" + String.valueOf(new MonotonicArray().isMonotonic(nums1)));
        System.out.println("isMonotonic2:" + String.valueOf(new MonotonicArray().isMonotonic(nums2)));
        System.out.println("isMonotonic3:" + String.valueOf(new MonotonicArray().isMonotonic(nums3)));
        System.out.println("isMonotonic4:" + String.valueOf(new MonotonicArray().isMonotonic(nums4)));
        System.out.println("isMonotonic5:" + String.valueOf(new MonotonicArray().isMonotonic(nums5)));

    }
}
