package leetcode.array.twopointers;
/*
    925 Long Pressed Name
    https://leetcode.com/problems/long-pressed-name/

    Your friend is typing his name into a keyboard.  Sometimes, when typing a character c, the key might get long pressed, and the character will be typed 1 or more times.

You examine the typed characters of the keyboard.  Return True if it is possible that it was your friends name, with some characters (possibly none) being long pressed.



Example 1:

Input: name = "alex", typed = "aaleex"
Output: true
Explanation: 'a' and 'e' in 'alex' were long pressed.
Example 2:

Input: name = "saeed", typed = "ssaaedd"
Output: false
Explanation: 'e' must have been pressed twice, but it wasn't in the typed output.
Example 3:

Input: name = "leelee", typed = "lleeelee"
Output: true
Example 4:

Input: name = "laiden", typed = "laiden"
Output: true
Explanation: It's not necessary to long press any character.


Note:

name.length <= 1000
typed.length <= 1000
The characters of name and typed are lowercase letters.

loop typed string
use n to through name

如果相等 移動n到下一個 （typed會自己移動

但如果發現不一樣

要檢查typed[cur] 和 typed[cur -1]是否一樣, 不一樣代表不是連續的key錯, 另外, 如果不一樣的狀況下且 typed index 是0代表一開始就 key 錯了

最後檢查n是否跟name真的長度一樣

time: o(n), space: o(1)
 */
public class LongPressedName {

    public static boolean isLongPressedName(String name, String typed) {
        if(name == null || typed == null) return false;

        int n = 0;
        int nameLen = name.length();
        int typedLen = typed.length();

        for (int t = 0; t < typedLen; t++) {
            if (n < nameLen && name.charAt(n) == typed.charAt(t)) { // 一樣, 移動 name index
                n++;
            } else if (t == 0 || typed.charAt(t) != typed.charAt(t-1)) { //不一樣, 檢查typed cur index 和前一個index,    若0, 代表一開始就不一樣
                return false;
            }
        }
        System.out.println("n:" + n);
        System.out.println("nameLen:" + nameLen);

        return n == nameLen; // 要比較這樣, 如果typed前面都對, 後面多打（name沒有的字, n長度會小於nameLen), 如 test case
    }

    public static void main(String[] args) {
        String name = "pyplrz";
        String typed = "ppyypllr";
        LongPressedName.isLongPressedName(name, typed);
    }
}

