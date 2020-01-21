package java8.sort;

import java.util.Arrays;
import java.util.Comparator;

public class ArraySort {

    public static void main(String[] args) {

        //reverse sort
        Integer[] a = {9, 8, 7, 2, 3, 4, 1, 0, 6, 5};
        Comparator cmp = (o1, o2) -> (Integer)o2-(Integer)o1;
        Arrays.sort(a, cmp);
        for(int i = 0; i < a.length; i ++) {
            System.out.print(a[i] + " ");
        }
    }

}
