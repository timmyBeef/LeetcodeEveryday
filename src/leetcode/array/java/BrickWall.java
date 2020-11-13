package leetcode.array.java;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    time: O(n), because we only have n bricks, it just stores in a nested list
    space: O(n)

    from pic, we can observe, the least bricks case happens at the max common brick width
    use hashmap, record acc width cnt and find "max cnt of acc width"
    result is bricks rows - max cnt of acc width
 */
public class BrickWall {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();

        int maxCnt = 0;
        for (List<Integer> list : wall) {
            int sum = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                sum += list.get(i);

                int curCnt = map.getOrDefault(sum, 0) + 1;
                map.put(sum, curCnt);

                maxCnt = Math.max(maxCnt, curCnt);
            }
        }

        return wall.size() - maxCnt;
    }
}
