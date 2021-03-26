package Interviews;

import com.sun.xml.internal.ws.util.StringUtils;

import java.time.LocalDate;

public class StringTest {
    public static void main(String[] args) {
        String a = "123";
        String b = "123";
        String c = new String("123");
        System.out.println(a == b);
        System.out.println(b == c);
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
//        LocalDate localDate = LocalDates.fromString(date + "01", "yyyyMMdd");
////        localDate.getDayOfMonth();

        String msg = "CustomizedException{code=null, message=無此電號}";
        System.out.println(msg.substring(msg.indexOf("message=")+8, msg.indexOf("}")));

    }
}
