package leetcode;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Fib {
    public int fib(int n){
        if(n == 0) return 0;

        if(n == 1) return 1;

        return fib(n-1)+fib(n-2);
    }

    public int fibInter(int n){
        int result = 0;
        int a[] = new int[n+1];
        a[0] = 0;
        a[1] = 1;

        for(int i=2; i < n+1; i++) {
            result = a[i-1] + a[i-2];
            a[i] = result;
        }


        return a[n];
    }

    //java 8 stream way
    public int fibStream(int series) {
        List<Integer> result = Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(series+1)
                .map(n -> n[0])
                .collect(Collectors.toList());
        return result.get(series);
    }

    public static void main(String[] args) {

        Fib fib = new Fib();

        System.out.println(fib.fib(6));
        System.out.println(fib.fibInter(6));


        System.out.println(fib.fibStream(6));

        long a = 0;
        long b = 1555l;
        System.out.println(Math.round(88.6));

        System.out.println(Math.round(((float)(b-a)/(float)b)*100));

    }
}
