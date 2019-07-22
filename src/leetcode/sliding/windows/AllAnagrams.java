package leetcode.sliding.windows;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/find-all-anagrams-in-a-string/

/*      Input:
        s: "cbaebabacd" p: "abc"

        Output:
        [0, 6]

        Explanation:
        The substring with start index = 0 is "cba", which is an anagram of "abc".
        The substring with start index = 6 is "bac", which is an anagram of "abc".


        Input:
        s: "abab" p: "ab"

        Output:
        [0, 1, 2]

        Explanation:
        The substring with start index = 0 is "ab", which is an anagram of "ab".
        The substring with start index = 1 is "ba", which is an anagram of "ab".
        The substring with start index = 2 is "ab", which is an anagram of "ab".

      time:  O(S+T) ,
      S search string length(traversal data),
      T pattern string length(build the map time)

      space: O(T)
*/

public class AllAnagrams {

    // use template
    public List<Integer> findAnagrams(String s, String t) {
        List<Integer> result = new ArrayList<>(); //不一樣的地方

        if (t.length() > s.length()) return result;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int counter = map.size();

        int begin = 0, end = 0;

        while (end < s.length()) {

            // move right
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) counter--;
            }
            end++;

            while (counter == 0) { // 代表 match 完了

                // move letf
                // 所以左邊要開始繼續右移, 右移的過程中, 如果是原本符合的字, 要把 map 對應的 count +回去
                char tempc = s.charAt(begin);
                if (map.containsKey(tempc)) {
                    map.put(tempc, map.get(tempc) + 1);
                    if (map.get(tempc) > 0) {
                        counter++;
                    }
                }

                //不一樣的地方
                if(end-begin == t.length()){
                    result.add(begin);
                }

                begin++; // move left
            }

        }
        return result;
    }

    // https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/175381/Sliding-Window-Logical-Thinking
    public List<Integer> findAnagramsEasy(String s, String p) {

        int slen = s.length(), plen = p.length();
        List<Integer> startIndices = new ArrayList<>();
        int[] dictS = new int[26], dictP = new int[26];

        // Map char to frequency in p.
        for (char ch : p.toCharArray())
            dictP[ch - 'a']++;

        int right = 0; // [left, right) is current window.
        for (int left = 0; left < slen; left++) {

            // 建立 s window 內容（跟 p window 一樣大小） , left   right
            while (right < slen && right - left + 1 <= plen) {
                dictS[s.charAt(right) - 'a']++;
                right++;
            }

            // 如果 s window 和 p window 一樣, 紀錄 sart index
            if (Arrays.equals(dictS, dictP)) startIndices.add(left);

            // 要跑下一個回圈, 也就是 left index 右移, 把目前 s window 內佔據的值拿掉
            dictS[s.charAt(left) - 'a']--;
        }

        return startIndices;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(new AllAnagrams().findAnagrams(s, p).toString());

    }

}
