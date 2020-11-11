package leetcode.array.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
    leetcode 447
    count the dist of each other points, records in map (dist, point's count)

    when point's count >= 2, it has combination of Boomerangs

    i j equals i k
    {{1, 0}, {0, 0}, {2, 0}} or {{1, 0}, {2, 0}, {0, 0}} 2 way

    for {1, 0},  there is 2 kinds of ponit dist is 1
    so combination is 2*(2-1) = 2

    time: O(n^2)
    space: O(n)
 */
public class NumberOfBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                int dist = getDistance(points[i], points[j]);
                System.out.println("i:" + i + ", j:" + j + ",dist:" + dist + "\n");

                map.put(dist, map.getOrDefault(dist, 0) + 1);
                System.out.println(map.toString() + "\n");
            }
            for (int value : map.values()) {
                res += value * (value - 1);
            }
            System.out.println("res=" + res);

            map.clear();
            System.out.println("clear\n");
        }
        return res;
    }

    private int getDistance(int[] a, int[] b) {
        System.out.println("a:" + Arrays.toString(a) + ", b:" + Arrays.toString(b));

        int dx = a[0] - b[0];
        int dy = a[1] - b[1];
        return dx * dx + dy * dy;
    }

    public static void main(String[] args) {
        NumberOfBoomerangs app = new NumberOfBoomerangs();
        int[][] input = {{0, 0}, {1, 0}, {2, 0}}; // {{1, 0}, {0, 0}, {2, 0}} or {{1, 0}, {2, 0}, {0, 0}} 2 way
        app.numberOfBoomerangs(input);
    }
}

