package leetcode.array.twopointers;
/*
    https://leetcode.com/problems/backspace-string-compare/
 */
public class BackspaceStringCompare {

    public boolean backspaceCompare(String S, String T) {
        int i = S.length()-1;
        int j = T.length()-1;
        int countS = 0;
        int countT = 0;
        while (i >= 0 || j >= 0) {
            while (i >= 0 && (countS > 0 || S.charAt(i) == '#')) {
                if (S.charAt(i) == '#') countS++;
                else countS--;
                i--;
            }
            char left = i < 0 ? '@' : S.charAt(i);
            while (j >= 0 && (countT > 0 || T.charAt(j) == '#')) {
                if (T.charAt(j) == '#') countT++;
                else countT--;
                j--;
            }
            char right = j < 0 ? '@' : T.charAt(j);
            if (left != right) return false;
            i--;
            j--;
        }
        return true;
    }
}
