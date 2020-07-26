package leetcode.kth;

import java.util.*;

public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> maxFreq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

        maxFreq.addAll(map.keySet());

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(maxFreq.remove());
        }
        return result;
    }

    public static void main(String[] args) {
        int in[] = {1, 1, 3, 3, 3, 2};
        System.out.println(new TopKFrequentElements().topKFrequent(in, 2));

        System.out.println(new TopKFrequentElements().topKFrequentByBucket(in, 2));

//        int result[] = new TopKFrequentElements().topKFrequent2(in, 2);

//        for (int i : result) {
//            System.out.println(i);
//        }

    }

    /*
        bucket[freq]

        [3] -> [3]key1, [3]key2
        [2] -> [2]key


        res.add([3]key1, [3]key2, [2]key)
     */

    public int[] topKFrequentByBucket(int[] nums, int k) {

        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = bucket.length - 1; i >= 0 && result.size() < k; i--) {
            if (bucket[i] != null) {
                result.addAll(bucket[i]);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

}
