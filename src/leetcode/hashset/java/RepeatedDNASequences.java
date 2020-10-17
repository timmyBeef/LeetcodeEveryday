package leetcode.hashset.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/*
    leetcode 187
    time: O(n)
    space: O(n)
 */
public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();

        // 把每個子字串（長度10) 丟到 set, 如果存在 seen 了， add 時會回 false
        // 在加到結果 (repeated)
        for (int i = 0; i < s.length() - 9; i++) {
            String tmp = s.substring(i, i + 10);
            if (!seen.add(tmp)) { // 在這做加入, 若存在會回 false
                repeated.add(tmp);
            }
        }
        return new ArrayList<>(repeated);

    }
}
