package tools;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Tools {
    /*
        SELECT APPL_NO as applNo, APPL_ITEM_NAME as applItemName, APPL_DT as applDt, Case_Sts as caseSts,
        APPL_NAME as applName, EMAIL as email, ISNULL(TEL_AREA,'') as tel, ISNULL(TEL_NO,'') as telNo, ISNULL(TEL_NO,'') as telExt,
        MOBIL as mobil, CUST_NO as custNo, CUST_NAME as custName, ISNULL(CUST_ADDR1,'') as custAddr1,ISNULL(CUST_ADDR2,'') as custAddr2,
        ISNULL(CUST_ADDR3,'') as custAddr3, waat, ReadingType2 as readingType FROM ApplCase
     */
    public static void main(String[] args) {
        String str = "SELECT APPL_NO as applNo, APPL_ITEM_NAME as applItemName, APPL_DT as applDt, Case_Sts as caseSts,\n" +
                "        APPL_NAME as applName, EMAIL as email, ISNULL(TEL_AREA,'') as tel, ISNULL(TEL_NO,'') as telNo, ISNULL(TEL_NO,'') as telExt,\n" +
                "        MOBIL as mobil, CUST_NO as custNo, CUST_NAME as custName, ISNULL(CUST_ADDR1,'') as custAddr1, ISNULL(CUST_ADDR2,'') as custAddr2,\n" +
                "        ISNULL(CUST_ADDR3,'') as custAddr3, waat, ReadingType2 as readingType FROM ApplCase";

        List<String> in = Arrays.asList(str.split(" "));
        IntStream.rangeClosed(0, in.size()-1).forEach(i -> {

            if ("as".equals(in.get(i))) {
                System.out.println("private String " + in.get(i+1).replace(",", "").replace("\n", "") + ";");
            }
        });


    }
}
