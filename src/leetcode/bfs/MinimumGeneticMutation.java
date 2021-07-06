package leetcode.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
    433. Minimum Genetic Mutation
    https://app.gitbook.com/@timmybeeflin/s/cracking-leetcode/433.-minimum-genetic-mutation

    notice the not found case => return -1
    time: O(m*n), O(8 *4)
    space: O(m*n), O(8 *4)
 */
public class MinimumGeneticMutation {
    public int minMutation(String start, String end, String[] bank) {
        // like wordladder
        // use BFS to find sortest path
        // store bank in hashset for checking doest it exist in bank[]
        if (bank == null || bank.length == 0) return -1;

        Set<String> set = new HashSet<>();
        for (String s : bank) {
            set.add(s);
        }
        set.remove(start);

        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        int res = 0;

        char mutation[] = new char[]{'A', 'C', 'G', 'T'};

        while (!queue.isEmpty()) {
            int qSize = queue.size();
            for (int q = 0; q < qSize; q++) {
                String cur = queue.poll();

                if (cur.equals(end)) return res;

                for (int i = 0; i < cur.length(); i++) {
                    for (int j = 0; j < mutation.length; j++) {
                        char charArray[] = cur.toCharArray();
                        charArray[i] = mutation[j];
                        String newGene = String.valueOf(charArray);
                        if (set.contains(newGene)) {
                            queue.offer(newGene);
                            set.remove(newGene);
                        }
                    }
                }
            }
            res++;
        }
        return -1;
    }

}
