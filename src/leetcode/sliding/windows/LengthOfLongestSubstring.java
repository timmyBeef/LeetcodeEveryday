package leetcode.sliding.windows;

import java.sql.Time;
import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {

    /*
        same idea as sliding window

        if(map.get(c) > 1) counter++; => repeat char

     */

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int begin = 0, end = 0, counter = 0, d = 0;

        while (end < s.length()) {
            // > 0 means repeating character
            //if(map[s.charAt(end++)]-- > 0) counter++;
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if(map.get(c) > 1) counter++;
            end++;

            while (counter > 0) {
                //if (map[s.charAt(begin++)]-- > 1) counter--;
                char charTemp = s.charAt(begin);
                if (map.get(charTemp) > 1) counter--;
                map.put(charTemp, map.get(charTemp)-1);
                begin++;
            }
            d = Math.max(d, end - begin);
        }
        return d;
    }

    // https://stackoverflow.com/questions/32878514/when-to-initialize-an-array-with-256
/*
    sliding window
    step1 使用一個 boolean array 來記錄哪幾個 char 出現過了,
           here are 2^8 = 256 chars in an extended ASCII char set. 所以是 256 的大小
           有兩個指標, i 和 j,
           maxLen

    step2 沒有重複時, 持續移動j, 並記錄j的字是否出現
    step3 重複時, 開始移動i的位置, 直到沒有重複的位置
    step4 持續更新長度 Math.max(j - i + 1, maxLen)

    回傳 maxLen

    ex:
    String s = "pwwkew";
            j =0, ex[p] = true  maxLen=1
            j= 1, ex[w] = true  maxLen=2
            j= 2, i = 0, j exists w, ex[p] = false; i++;
                  i = 1, j exists w, ex[w] = false; i++
                  i = 2, j not exists w
                  ex[w] = true;  maxLen=2
            j= 3, ex[k] = true;  maxLen=2
            j= 4, ex[e] = true;  maxLen=3
            j= 5  i = 2, j exists w ex[w] = false; i++;
                  i = 3, j not exists w
                  ex[w] = true;  maxLen=3



    Time complexity : O(n). Index j will iterate n times.
    Space complexity (Table): O(m). m is the size of the charset.
*/
    public int simple(String s) {
        boolean[] exist = new boolean[256];
        int i = 0, maxLen = 0;
        for (int j = 0; j < s.length(); j++) {
            while (exist[s.charAt(j)]) { // 重複時, 開始移動i的位置, 直到沒有重複的位置
                exist[s.charAt(i)] = false; //因為持續往左移動, 所以會把原本重複的字, 更新掉成不出現
                i++;
            }
            exist[s.charAt(j)] = true;
            maxLen = Math.max(j - i + 1, maxLen);
        }
        return maxLen;
    }

    public static void main(String[] args) {

        String s = "pwwkew";
        System.out.println(String.valueOf(new LengthOfLongestSubstring().simple(s)));

    }
}
