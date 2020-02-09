package java8.optional;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

public class OptionalDemo {
    public static void findOdd() {
        Optional<String> firstOdd =
                Stream.of("1234", "123456", "12")
                        .filter(s -> s.length() % 2 != 0)
                        .findFirst();

        // System.out.println(firstOdd.get()); // throw NoSuchElementException

        // 使用 orElse() 處理 取不到值 時該回什麼

        System.out.println(firstOdd.orElse("no odd length string"));

        System.out.println(firstOdd.orElseGet(() -> "no odd length string"));

        System.out.println(firstOdd.orElseThrow(() -> new NoSuchElementException()));

        System.out.println(firstOdd.orElseThrow(NoSuchElementException::new));

        firstOdd.ifPresent(val -> System.out.println("find it!"));
    }

    public static void main(String[] args) {
        OptionalDemo.findOdd();
    }
}
