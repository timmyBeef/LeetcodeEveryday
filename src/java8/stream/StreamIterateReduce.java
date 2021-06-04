package java8.stream;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Stream;

public class StreamIterateReduce {

    public void test() {
//        int n = 100000;
//        Long result = Stream.iterate(1L, i -> i + 1)
//                .limit(n)
//                .reduce(0L, (i, j) -> i + j);
//        System.out.println(result);
//
//        Long sum = 0L;
//        for (int i = 1; i <= n; i++) {
//            sum += i;
//        }
//        System.out.println(sum);
        int m = 49999999;
        System.out.println("treeset now:" + LocalDateTime.now());
        TreeSet<Long> set = new TreeSet<>();
        for (Long i = 1L; i <= m; i++) {
            set.add(i);
        }
        set.stream().parallel().reduce(0L, (i, j) -> i + j);
        System.out.println("after:" + LocalDateTime.now() + "\n");

        System.out.println("array list now:" + LocalDateTime.now());
        List<Long> list = new ArrayList<>();
        for (Long i = 1L; i <= m; i++) {
            list.add(i);
        }
        list.stream().parallel().reduce(0L, (i, j) -> i + j);
        System.out.println("after:" + LocalDateTime.now() + "\n");

        System.out.println("linked list now:" + LocalDateTime.now());
        List<Long> list2 = new LinkedList<>();
        for (Long i = 1L; i <= m; i++) {
            list2.add(i);
        }
        list2.stream().parallel().reduce(0L, (i, j) -> i + j);
        System.out.println("after:" + LocalDateTime.now() + "\n");
    }

    public static void main(String[] args) {
        new StreamIterateReduce().test();
    }
}
