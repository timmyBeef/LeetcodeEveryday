package java8.stream;

import java.util.stream.IntStream;

public class IntStreamEx {

    public void demo() {
        IntStream.generate(() -> (int) (Math.random() * 10000))
                .limit(10)
                .forEach(System.out::println);
    }

    public static void main(String args[]) {
        new IntStreamEx().demo();
    }
}
