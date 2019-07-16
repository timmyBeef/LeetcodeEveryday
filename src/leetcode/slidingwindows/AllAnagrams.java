package leetcode.slidingwindows;


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

    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;

        int[] hash = new int[256]; //character hash

        //record each character in p to hash
        for (char c : p.toCharArray()) {
            hash[c]++;
        }
        //two points, initialize count to p's length
        int left = 0;
        int right = 0;
        int count = p.length(); // find string's length, so we should make this count to zero: means we find it.

        while (right < s.length()) {
            //move right everytime, if the character exists in p's hash, decrease the count
            //current hash value >= 1 means the character is existing in p
            if (hash[s.charAt(right)] >= 1) {
                count--;
            }
            // 目前此 index 處理過了, hash --, index right 右移
            hash[s.charAt(right)]--;
            right++;

            //when the count is down to 0, means "we found the right anagram"
            //then add window's left to result list, 紀錄 left, 因為我們要的是 anagram 起始 index
            if (count == 0) {
                list.add(left);
            }
            //if we find the window's size equals to p,
            //then we have to move left (narrow the window) to find the new match window

            //++ to reset the hash because we kicked out the left => ?

            //only increase the count if the character is in p
            //如果不存在預設 hash 中的值（從p的字母）, 處理過會變 小於0(負的), 所以當 hash >=0 時, 才需要恢復 count, 代表繼續判斷
            // hash++, 代表 恢復處理這個值
            //the count >= 0 indicate it was original in the hash, cuz it won't go below 0
            if (right - left == p.length() ) {

                if (hash[s.charAt(left)] >= 0) {
                    count++;
                }
                hash[s.charAt(left)]++;
                left++;

            }


        }
        return list;
    }

    //O(slen * plen)
    //O(1)
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
