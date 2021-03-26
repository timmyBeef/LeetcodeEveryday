package Interviews;

public class NumTest {
    public void add(long i) {
        i++;
    }

    public void wrapperAdd(Long i) {
        i++;
    }

    public static void main(String[] args) {
        NumTest t = new NumTest();
        long a = 123;
        long b = a;
        Long c = new Long(123);
        t.add(a);
        t.add(b);
        t.wrapperAdd(c);

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

    }
}
