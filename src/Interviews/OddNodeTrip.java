package Interviews;

import java.util.*;

public class OddNodeTrip {

    private int helper(int arr[]) {
        int res = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0 && i != 0) {
                queue.offer(i);
            }
        }
        System.out.println(queue.toString());
        List<List<Integer>> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> li = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                int next = queue.poll();
                li.add(next);
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] == next && i != next) {
                        queue.offer(i);
                    }
                }
            }
            list.add(li);
            res++;
        }
        return res;
    }

    private int helper2(int arr[]) {
        int res = 0;
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 1) {
                queue.offer(i); // 1 3 5 7 9
            }
        }
        System.out.println("init:"+queue.toString());
        List<List<Integer>> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> li = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                int next = queue.poll();
                System.out.println("next:" + next);
                li.add(next);
                if (arr[next] % 2 == 0) {
                    queue.offer(arr[next]);
                }

                System.out.println("add:"+queue.toString());

            }
            list.add(li);
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new OddNodeTrip().helper2(new int[]{0, 9, 0, 2, 6, 8, 0, 8, 3, 0})); // return 4
        //System.out.println(new OddNodeTrip().helper2(new int[]{0, 0, 0, 1, 6, 1, 0, 0})); // return 3

    }
}
