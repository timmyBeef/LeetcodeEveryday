package leetcode.bfs;

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Set<String> dict = new HashSet<>(wordList);
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);

        int step = 1;
        Set<String> visited = new HashSet<>();
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }
            Set<String> temp = new HashSet<>();
            for (String word : beginSet) {
                char[] chs = word.toCharArray();
                for (int i = 0; i < chs.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = chs[i];
                        chs[i] = c;
                        String target = String.valueOf(chs);
                        if (endSet.contains(target)) {
                            return step + 1;
                        }
                        if (!visited.contains(target) && dict.contains(target)) {
                            temp.add(target);
                            visited.add(target);
                        }
                        chs[i] = old;
                    }
                }
            }
            beginSet = temp;
            step++;
        }
        return 0;
    }

    public int ladderLengthSingleBFS(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (set.size() == 0 || !set.contains(endWord)) {
            return 0;
        }
        set.remove(beginWord);

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        int step = 1;
        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) { //BFS
                String cur = q.poll();
                for (int j = 0; j < cur.length(); j++) {
                    for (char c = 'a'; c <= 'z'; c++) { // replace char one by one
                        char[] charArray = cur.toCharArray();
                        charArray[j] = c;
                        String newWord = String.valueOf(charArray);
                        if (set.contains(newWord)) { // if set exists newWord
                            if (newWord.equals(endWord)) { // find endword then return
                                return step + 1;
                            }
                            q.offer(newWord); // other case, keep going
                            set.remove(newWord); // remove newWord from set
                        }

                    }
                }
            }
            step++;
        }
        return 0;
    }


    public static void main(String[] args) {
        System.out.println(new WordLadder().ladderLengthSingleBFS("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
    }
}
