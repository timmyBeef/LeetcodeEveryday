package java8.map;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;
/*

https://www.baeldung.com/java-maps-streams

https://www.baeldung.com/java-stream-sum

remember to import
import java.util.function.*;
import java.util.stream.*;

 */
public class StreamMap {

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

//        Stream a = Arrays.stream(ar).boxed(); //need boxed to Stream
//        IntStream b = Arrays.stream(ar);

        return Arrays.stream(ar).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .mapToInt(v -> v.getValue().intValue()/2)
                .sum();

    }

    public static void main(String args[]){
        StreamMap.sockMerchantByStream(7, new int[]{1,2,1,2,1,3,2});
    }
}
