package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

abstract class Test {
    private String id;
    private String addr;

    public Test(String addr, String id) {
        this.id = "father";
        this.addr = addr;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    protected void modifyAddr(String addr) {
        this.addr = addr;
    }

    //    public static void main(String ars[]) {
//        new Test().exe();
//
//
//    }
//    public void exe() {
//        long a = 123;
//        long b = a;
//        Long c = new Long(123);
//
//        add(a);
//        add(b);
//        wrapperAdd(c); // wrapper class add
//
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(c);
//        //之後忘了
//    }
//
//    public void wrapperAdd(Long a) {
//        //有點忘了
//    }
//
//    public void add(long a) {
//        a++;
//    }
}

class Test2 extends Test {
    private String id;
    private String addr;

    public Test2(String addr, String id) {
        super(addr, id);
        this.addr = addr;
        this.id = id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getAddr() {
        return addr;
    }

    @Override
    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    protected void modifyAddr(String addr) {
        this.addr = addr;
    }

    public static void main(String ars[]) {
        Test t = new Test2("addr1", "id1");
        Test2 t2 = (Test2)t;


        System.out.println(t.getAddr());
        System.out.println(t.getId());

        System.out.println(t2.getAddr());
        System.out.println(t2.getId());

        List<String> list = Arrays.asList("0", "-1","-2");

        System.out.println(list.stream().sorted((o1,o2) -> Integer.parseInt(o2) - Integer.parseInt(o1))
                .collect(Collectors.toList()));

    }

}


