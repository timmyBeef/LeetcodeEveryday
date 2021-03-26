package Interviews;

import java.util.*;


public class MapTest {
    public static void main(String args[]) {
//        Map<Planning, String> objects = new HashMap<Planning, String>();
//        Planning planning1 = new Planning("Monday");
//        Planning planning2 = new Planning("Tuesday");
//        Planning planning3 = new Planning("Tuesday");
//        objects.put(planning1, "Reading");
//        objects.put(planning2, "Dancing");
//        objects.put(planning3, "Drawing");
//        System.out.println("Size :" + objects.size());
        String a = "0112345678";
        System.out.println(a.substring(2, a.length()));
    }
}

class Planning {
    String day;

    public Planning(String today) {
        day = today;
    }

    public boolean equals(Object object) {
        return ((Planning) object).equals(day);
    }
}

