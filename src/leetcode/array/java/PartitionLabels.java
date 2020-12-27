package leetcode.array.java;

import java.util.ArrayList;
import java.util.List;

/*
    Time: O(n)
    Space: O(1)

    start end index two pointer + map

    idea,
    1. record char's last index
    2. for check current index equals to max end index, if true, it's a group
 */
public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        int[] map = new int[26];
        for (int i = 0; i < S.length(); i++) {
            map[S.charAt(i) - 'a'] = i;
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < S.length(); i++) {
            end = Math.max(end, map[S.charAt(i) - 'a']);

            if (end == i) {
                result.add(end - start + 1);
                start = end + 1;
            }
        }
        return result;
    }
}
