package leetcode.array.twopointers;
/*
    844. Backspace String Compare
    https://leetcode.com/problems/backspace-string-compare/

    Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".
Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".
Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".
Example 4:

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".
Note:

1 <= S.length <= 200
1 <= T.length <= 200
S and T only contain lowercase letters and '#' characters.
Follow up:

Can you solve it in O(N) time and O(1) space?

    用count紀錄#, 如果cur是# count++, 如果不是代表抵銷, count--

    去這樣移動pointer到沒有＃的地方

    另一個string 也做一樣的事後

    兩者比較, 不一樣就先跳出了

    繼續loop

    重複剛剛的行為

    最後都沒問題

    就是兩者相同

    use count to record #'s count

    while count > 0 || cur == '#'

    do count++ or count--

    move the pointer


        // compare each char
        // if encounter #, should count++, int that we know how many word we can passby
        // if after pass by, char is not equal to each other, we should return false
        // all pass means they equal to each other

    O(n)
    O(1)
 */
public class BackspaceStringCompare {

    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1;
        int j = T.length() - 1;
        int countS = 0; // use count to record #'s count
        int countT = 0;

        while (i >= 0 || j >=0) {
            while (i >= 0 && (countS > 0 || S.charAt(i) == '#') ) {
                if (S.charAt(i) == '#') {
                    countS++;
                } else {
                    countS--;
                }
                i--;
            }
            char left = i < 0 ? '@' : S.charAt(i);

            while (j >= 0 && (countT > 0 || T.charAt(j) == '#') ) {
                if (T.charAt(j) == '#') {
                    countT++;
                } else {
                    countT--;
                }
                j--;
            }
            char right = j < 0 ? '@' : T.charAt(j);

            if (left != right) {
                return false;
            }
            i--;
            j--;
        }
        return true;
    }
}
