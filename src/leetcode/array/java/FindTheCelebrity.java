package leetcode.array.java;
/*
    leetcode 277
    time: O(n)
    space: O(1)

    1. first loop, set 0 to be the Celebrity first, then for loop 1~n-1, if res knows i,
       it means, i maybe is the Celebrity! so record it

    2. second loop, check the Celebrity, if meet these condition, return -1 (not a Celebrity)
       1. Celebrity doesn't exist in 0~n-1
          => (res != i)
       2. Celebrity knows other ones || no one konws Celebrity
          => (knows(res, i) || !knows(i, res)

    3. return res
 */
public class FindTheCelebrity {
    public int findCelebrity(int n) {
        if (n < 2) return -1;

        int res = 0; // Celebrity
        for (int i = 1; i < n; i++) {
            if (knows(res, i)) {
                res = i;
            }
        }
        for (int i = 0; i < n; i++) {
            if (res != i && (knows(res, i) || !knows(i, res))) {
                return -1;
            }
        }
        return res;
    }

    // mocking knows method
    boolean knows(int a, int b) {
        return true;
    }
}
