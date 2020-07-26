package leetcode.kth;

import java.util.*;

/*
    Sort Characters By Frequency
    https://leetcode.com/problems/sort-characters-by-frequency/

    O(nlogm), m is the distinguish character, can be O(1) since only 26 letters.
    So the overall time complexity should be O(n), the same as the buck sort with less memory use.
 */

public class FrequencySort {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

        maxHeap.addAll(map.keySet());

        StringBuilder result = new StringBuilder();
        while(!maxHeap.isEmpty()) {
            char current = maxHeap.remove();
            for (int i = 0; i < map.get(current); i++) {
                result.append(current);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "eaaac";
        System.out.println(new FrequencySort().frequencySort(s));
    }
}
