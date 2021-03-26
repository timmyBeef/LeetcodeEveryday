package leetcode.kth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }

        List<String> bucket[] = new List[words.length + 1];
        for (String key : map.keySet()) {
            int freq = map.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        List<String> result = new ArrayList<>();
        for (int i = bucket.length - 1; i >= 0 && k > 0; i--) {
            if (bucket[i] != null) {
                bucket[i] = bucket[i].stream().sorted().collect(Collectors.toList());
                for (int j = 0; j < bucket[i].size() && j < k; j++) {
                    result.add(bucket[i].get(j));
                }
                k -= result.size();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new TopKFrequentWords().topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4);
    }
}
