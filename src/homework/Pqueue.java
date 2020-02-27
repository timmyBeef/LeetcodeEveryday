package homework;

import java.util.PriorityQueue;

public class Pqueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();

        pQueue.add(10);
        pQueue.add(20);
        pQueue.add(30);
        pQueue.add(40);
        pQueue.add(50);
        pQueue.add(5);

        while(true) {
            Integer value = pQueue.poll();

            if(value == null) break;

            System.out.println(value);

        }

    }
}
