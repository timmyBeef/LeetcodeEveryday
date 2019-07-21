package leetcode;

// https://leetcode.com/problems/first-bad-version/
/*
    use binary search,
    two pointer left = 0, right = n
    becuase bad are in the later order
    so when mid is bad, we should toward left to find
    or toward right to find

 1 2 3 4 5 6 7 8 9
 G G G B B B B B B       G = Good, B = Bad
 |       |       |
left    mid    right

Time complexity : O(logn). The search space is halved each time, so the time complexity is O(logn).

Space complexity : O(1).
 */
public class FirstBadVersion {

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while(left < right) {
            int mid = left + (right-left)/2;

            if(isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid +1;
            }
        }

        return left;
    }

    boolean isBadVersion(int m) {
        return true;
    }
}
