package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/remove-invalid-parentheses/

以 String input1 = "()())()"; 為例

用 stack ++;
   stack --;
去判斷 (, ) 是否平衡出現
到 s[4] 發現竟然是負的: 代表 右括號先出現了

所以去處理要移掉0~3 哪一個 右括號

2 或 4 可以移掉
２移掉後, 遞迴再跑一次, 會處理剩下的字串

After the removal, the prefix is then valid. We then call the function recursively
to solve the rest of the string.
However, we need to keep another information: the last removal position.
If we do not have this position, we will generate duplicate by removing two ‘)’
in two steps only with a different order.
For this, we keep tracking the last removal position and only remove ‘)’ after that.

紀錄　iStart, jStart, 確保只跑後面剩下的遞迴(因為前面已經是對的了)
String remainStr = s.substring(0, j) + s.substring(j + 1, s.length());
s.substring(0, j) => 已經是對的

Recursion: iStart = i since we now have valid # closed parenthesis thru i.
jStart = j prevents duplicates

why use return
return; // Stop here. The recursive calls handle the rest of the string.

Now one may ask. What about ‘(‘? What if s = ‘(()(()’ in which we need remove ‘(‘?
The answer is: do the same from right to left.
However a cleverer idea is: reverse the string and reuse the code!

對於一個字符串，在任何時候如果')'的個數多於左括號，則說明從開始到現在位置必然可以刪除一個')'．
而這段子串可能包含多個')'，刪除哪一個呢？當然刪除任何一個都可以．例如對於()())()，
從開頭到s[4]位置構成的子串多了一個右括號，因此我們需要刪掉一個，而這個子串有三個右括號，但是只會產生２個結果，
也就是會有一個重複值．所以在刪除括號的時候，為保證不會產生重複值，需要記錄一個最後刪除的位置，
這樣可以使得在接下來刪除的時候只刪除這個位置之後的值．這樣我們可以使得當前這一段子串不再包含多餘的右括號了．
這樣我們可以刪除了一個右括號之後合法的子串與後面還沒有檢查過的子串組成一個新的字符串重新開始檢查．直到不再含有非法的右括號．

但是還有一種情況是包含了多餘的左括號，一種直觀的方法是從右向左再按照上面的方法處理一遍左括號．
但是將數組逆置之後就可以重用上面的算法了．

所以總的思路就是先對字符串進行處理使得其不再含有非法右括號，然後將其翻轉以後再檢查是否含有非法的左括號．
最後左右括號都檢查完之後都合法就是我們要的答案了．

O(N^2)

 */

public class RemoveInvalidParentheses {

    // String input1 = "()())()";
    public List<String> removeInvalidParentheses(String s) {
        List<String> output = new ArrayList<>();
        removeHelper(s, output, 0, 0, '(', ')');
        return output;
    }

    public void removeHelper(String s, List<String> output, int iStart, int jStart, char openParen, char closedParen) {
        int numOpenParen = 0, numClosedParen = 0;

        for (int i = iStart; i < s.length(); i++) {
            if (s.charAt(i) == openParen) numOpenParen++;   //!!!
            if (s.charAt(i) == closedParen) numClosedParen++;

            if (numClosedParen > numOpenParen) { // We have an extra closed paren we need to remove
                for (int j = jStart; j <= i; j++) { // Try removing one at each position, skipping duplicates

                    // !! s.charAt(j) == closedParen  s.charAt(j - 1) != closedParen   not () correct
                    if (s.charAt(j) == closedParen && (j == jStart || s.charAt(j - 1) != closedParen)) {
                        // Recursion: iStart = i since we now have valid # closed parenthesis thru i.
                        // jStart = j prevents duplicates
                        // j == jStart , it means the first one is ')', it's already illegle, so no need to check j-1
                        String newStr = s.substring(0, j) + s.substring(j + 1, s.length());
                        removeHelper(newStr, output, i, j, openParen, closedParen); //!!
                    }
                }
                return; // Stop here. The recursive calls handle the rest of the string.
            }
        }
        // No invalid closed parenthesis detected. Now check opposite direction,
        // or reverse back to original direction.
        String reversed = new StringBuilder(s).reverse().toString(); //!!
        if (openParen == '(')
            removeHelper(reversed, output, 0, 0, ')', '('); //!!!
        else
            output.add(reversed);
    }


    public List<String> removeInvalidParentheses2(String s) {
        List<String> ans = new ArrayList<>();
        removehelper2(s, ans, 0, 0, '(', ')');
        return ans;
    }

    public void removehelper2(String s, List<String> ans, int startI, int startJ, char openParen, char closedParen) {
        int numOpenParen = 0, numClosedParen = 0;
        for (int i = startI; i < s.length(); i++) {
           char c = s.charAt(i);
            if(c == openParen) numOpenParen++;
            if(c == closedParen) numClosedParen++;

            if(numClosedParen > numOpenParen) {
                for(int j = startJ; j <= i ; j++) {
                    if(s.charAt(j) == closedParen && (j == startJ || s.charAt(j-1) != closedParen)) {
                        String newStr = s.substring(0, j) + s.substring(j+1, s.length());
                        removehelper2(newStr, ans, i, j, openParen, closedParen);
                    }
                }
                return; //stop here!!!

            }


        } //end i //!!!!

        String reverseStr = new StringBuilder(s).reverse().toString(); //!!
        if(openParen == '(') {
            removehelper2(reverseStr, ans, 0, 0, ')', '('); //!!
        } else {
            ans.add(reverseStr); //再轉回來
        }
    }

    public static void main(String args[]) {
        String input1 = "()())()";
        String input2 = ")(";

        List<String> rs = new RemoveInvalidParentheses().removeInvalidParentheses(input2);
        System.out.println(rs.toString());
        rs.stream().forEach(r -> System.out.println(r));


    }
}
