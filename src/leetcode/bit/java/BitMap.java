package leetcode.bit.java;

import java.util.BitSet;

public class BitMap {
    public static void main(String[] args) {
        BitSet set = new BitSet(); // ADDRESS_BITS_PER_WORD = 6, 2^6 = 64
        set.set(0);
        System.out.println(set.size()); //64
        set.set(63);
        System.out.println(set.size()); //64
        set.set(64);
        System.out.println(set.size()); //128
        set.set(128);
        System.out.println(set.size()); //256 sometime extend by 128 or...maybe
        set.set(194);
        System.out.println(set.size()); //256
    }
}
