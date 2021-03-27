package leetcode.string;

/*
        leetcode 696. Count Binary Substrings
        time: O(n)
        space: O(1)
 */
public class CountBinarySubstrings {
    /*
        ex. 0011

        hit the first '1'
        when you hit the first '1', curRun = 1, preRun = 2,
        means 0s number is larger than 1s number, so we could form "01" at this time, count++ .

        hit the second '1',
        When you hit the second '1', curRun = 2, preRun = 2,
        means 0s' number equals to 1s' number, so we could form "0011" at this time, that is why count++)
     */
    public int countBinarySubstrings(String s) {
        if (s == null || s.length() == 0) return 0;

        int res = 0;
        int prev = 0;
        int cur = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) { // i from 1
                cur++;
            } else {
                prev = cur;
                cur = 1;
            }
            if (prev >= cur) { // 這樣可以計算到所有的結果
                res++;
            }
        }
        return res;
    }

}
