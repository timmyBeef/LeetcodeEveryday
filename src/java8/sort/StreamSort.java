package java8.sort;

import java.util.*;
import java.util.stream.Collectors;

/*
    transaction namber [1, 2, 3, 4, 1, 2]


Id(des),count(asc)

out:[[4, 1], [3, 1], [2, 2], [1, 2]]
 */
public class StreamSort {

    public List<List<Integer>> findDistinctA() {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 1, 2);

        list.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList())
                .stream().
                forEach(id -> {
                    int count = (int) list.stream().filter(v -> id == v).count();

                    result.add(Arrays.asList(id, count));
                });

        result.stream().sorted(Comparator.comparing(e -> e.get(1)));

        System.out.println("before:");
        System.out.println(result.toString());

        return result;
    }

    public List<List<Integer>> findDistinct() {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 1, 2);

        Set<Integer> set = new HashSet<>();
        for (int i : list) {
            set.add(i);
        }

        for (int s : set) {
            int count = 0;
            List<Integer> sub = new ArrayList<>();
            for (int i : list) {
                if (s == i) {
                    count++;
                }
            }
            sub.add(s);
            sub.add(count);
            result.add(sub);
        }
        System.out.println("before:");
        System.out.println(result.toString());

        //reverse another way
        //Comparator<List<Integer>> cmp = (o1, o2) -> (Integer) o2.get(0) - (Integer) o1.get(0);

        Comparator<List<Integer>> cmp = Comparator.comparing(e -> e.get(0));

        List<List<Integer>> finalResult = result.stream()
                .sorted(cmp.reversed().thenComparing(e -> e.get(1)))
                .collect(Collectors.toList());

        System.out.println("after:");
        System.out.println(finalResult.toString());
        return finalResult;
    }

    public void printHeap(String s) {

        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // use freq to sort
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

        maxHeap.addAll(map.keySet());

        while (!maxHeap.isEmpty()) {
            System.out.println(maxHeap.remove());
        }

    }

    public static void main(String args[]) {
        String str = "aabbbbbc";
        StreamSort s = new StreamSort();
        // new StreamSort().findDistinctA();

        // new StreamSort().findDistinct();
        s.printHeap(str);
    }
}
