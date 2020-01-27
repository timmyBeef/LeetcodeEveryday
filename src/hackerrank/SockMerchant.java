package hackerrank;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
/*
    https://www.hackerrank.com/challenges/sock-merchant/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup

 */
public class SockMerchant {
    static int sockMerchant(int n, int[] ar) {
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for(int sockId : ar) {
            if(set.contains(sockId)) {
                count++;
                set.remove(sockId);
            } else {
                set.add(sockId);
            }
        }
        return count;
    }

    static int sockMerchantByStream(int n, int[] ar) {

        return Arrays.stream(ar).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .mapToInt(v -> v.getValue().intValue()/2)
                .sum();

    }
}
