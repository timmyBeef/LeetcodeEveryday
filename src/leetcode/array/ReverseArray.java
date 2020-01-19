import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class ReverseArray {
  public static void main(String[] args) {
    int a[] = {1,3,4,5,6};
    int n = a.length - 1;

    for (int i = 0; i < n/2 ; i++) {
      int temp = a[i];
      a[i] = a[n-i];
      a[n-i] = temp;
    }
    
    for(int b : a) {
          System.out.println(b);
    }
      
  }
}
