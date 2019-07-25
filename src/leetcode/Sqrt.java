package leetcode;
/*
    left ~ right: 1~x

    finally, return right

    A little trick is using i <= x / i for comparison, instead of i * i <= x,
    to avoid exceeding integer upper limit.

    Binary Search Solution: Time complexity = O(lg(x)) = O(32)= O(1)  (log(2^32) = 32)

    O(1)
 */
public class Sqrt {
    public int mySqrt(int x) {
        int left = 1; //1~x
        int right = x;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (mid == x / mid) {
                return mid;
            } else if (mid < x / mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        return right; // in the end, right must < left, so ans is right
    }

    public static void main(String[] args) {
        System.out.print(new Sqrt().mySqrt(8));

        //System.out.print(new Sqrt().mySqrt(0));

    }
}