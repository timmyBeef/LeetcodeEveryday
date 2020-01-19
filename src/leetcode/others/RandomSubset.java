package leetcode.others;

import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class RandomSubset {

    public List<Integer> randomSubst(List<Integer> list) {
        Random random = new Random();

        Predicate<Object> flipCoin = o -> {
            return random.nextBoolean();
        };

        return list.stream()
                .filter(flipCoin).collect(Collectors.toList());

    }
}
