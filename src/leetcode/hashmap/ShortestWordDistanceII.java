package leetcode.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    244
    https://app.gitbook.com/@timmybeeflin/s/cracking-leetcode/hashtable/244.-shortest-word-distance-ii

    time: O(m+n)
    space: O(n)
 */
public class ShortestWordDistanceII {
    private Map<String, List<Integer>> map;
    public ShortestWordDistanceII(String[] wordsDict) {
        map = new HashMap<>();
        for (int i = 0; i < wordsDict.length ; i++) {
            String w = wordsDict[i];
            List<Integer> data = map.getOrDefault(w, new ArrayList<>());
            data.add(i);
            map.put(w, data);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> data1 = map.get(word1);
        List<Integer> data2 = map.get(word2);

        int i = 0, j = 0;
        int min = Integer.MAX_VALUE;
        while (i < data1.size() && j < data2.size()) {
            min = Math.min(min, Math.abs(data1.get(i) - data2.get(j)));

            if (data1.get(i) > data2.get(j)) {
                j++;
            } else {
                i++;
            }
        }
        return min;
    }
}

