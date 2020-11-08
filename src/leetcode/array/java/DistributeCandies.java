package leetcode.array.java;

/*
    time: O(n)
    space: O(n)

    sis wants unique type candies, she will get nums/2, so type counts is min(hashset size, nums/2)
 */
import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {
    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();
        for (int c : candies) {
            set.add(c);
        }
        return set.size() > candies.length/2 ? candies.length/2 : set.size();
        // return Math.min(set.size(), candies.length/2);
    }
}
