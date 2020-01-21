package leetcode.sliding.windows;

import java.util.HashMap;
import java.util.Map;
/*
    begin end, 決定window範圍

    建 map, 算出種類counter


 */
public class MinimumWinPrac2 {

    private Map<Character, Integer> buildMap(String t) {
        Map<Character, Integer> map = new HashMap<>();

        for(Character c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }

    public String solution(String s, String t) {
        int begin = 0;
        int end = 0;

        int len = Integer.MAX_VALUE;
        int head = 0;

        Map<Character, Integer> map = this.buildMap(t);
        int counter = map.size();


        while(end < s.length()) {
            Character endChar = s.charAt(end);

            if(map.containsKey(endChar)) { //移動end point
                int feq = map.get(endChar);
                map.put(endChar, feq--);
                if(feq == 0) {
                    counter--;
                }
            }

            end++;

            while(counter == 0) { //counter ==0 , 開始移動begin, 調整出最小window
                Character beginChar = s.charAt(begin);

                if(map.containsKey(beginChar)) {
                    int feq = map.get(beginChar);
                    map.put(beginChar, feq++);
                    if(feq > 0) {
                        counter++;
                    }
                }

                int newlen = end - begin;
                if(len > newlen) {
                    len = newlen;
                    head = begin;
                }

                begin++;
            }
        }
        if(len == Integer.MAX_VALUE) return "";

        return s.substring(head, head+len);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(new MinimumWinPrac2().solution(s, t));


    }
}
