package leetcode.sliding.windows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MinimumWinPrac {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int count = map.size();
        int head = 0;
        int len = Integer.MAX_VALUE;

        while (right < s.length()) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    count--;
                }
            }
            right++;

            while (count == 0) {
                char tempChar = s.charAt(left);
                if (map.containsKey(tempChar)) {
                    map.put(tempChar, map.get(tempChar) + 1);
                    if (map.get(tempChar) > 0) {
                        count++;
                    }
                }

                if (right - left < len) {
                    len = right - left;
                    head = left;
                }

                left++;
            }
        }

        if (len == Integer.MAX_VALUE) return "";
        return s.substring(head, head + len);

    }

    public List<Integer> findAnagrams(String s, String t) {
        List<Integer> result = new ArrayList<>();

        if (s.length() < t.length()) return result;

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int count = map.size();

        while (right < s.length()) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    count--;
                }
            }
            right++;

            while (count == 0) {
                char tempC = s.charAt(left);
                if (map.containsKey(tempC)) {
                    map.put(tempC, map.get(tempC) + 1);
                    if (map.get(tempC) > 0) {
                        count++;
                    }
                }

                if (right - left == t.length()) {
                    result.add(left);
                }

                left++;
            }
        }

        return result;
    }

    public int lengthOfLongestSubstring(String s) {
        boolean[] exists = new boolean[256];

        int left = 0;
        int maxlen = 0;
        for(int right=0; right < s.length(); right++) {
            while(exists[s.charAt(right)]) {
                exists[s.charAt(left)] = false;
                left++;
            }
            exists[s.charAt(right)] = true;
            maxlen = Math.max(maxlen, right - left + 1);
        }

        return maxlen;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(new MinimumWinPrac().minWindow(s, t));


        String s1 = "cbaebabacd";
        String p = "abc";
        System.out.println(new MinimumWinPrac().findAnagrams(s1, p).toString());

        String s2 = "pwwkew";
        System.out.println(String.valueOf(new MinimumWinPrac().lengthOfLongestSubstring(s2)));

    }
}
