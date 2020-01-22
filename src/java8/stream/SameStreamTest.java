package java8.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SameStreamTest {
    public static void main(String args[]) {
        List<String> list = Arrays.asList("1", "F", "2", "3");

//        Stream eStream = list.stream()
//                .filter(str -> !"F".equals(str))
//                .sorted();
//        //接電費 放最後
//        Stream linkEStream = list.stream()
//                .filter(str -> "F".equals(str));
//
//        Stream<String> s = Stream.concat(eStream, linkEStream);
//
//        s.forEach(System.out::println);



        list.stream()
                .sorted(Comparator.comparing((String s) -> s.equals("F")))
                .forEach(System.out::println);


    }
}
