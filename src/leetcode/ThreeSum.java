package leetcode;

import java.util.*;

public class ThreeSum {

/*
https://leetcode.com/problems/3sum/

    題目是要找出3數和為0的資料

    主要思想是，遍歷數組，用0減去當前的數，作為sum，然後再找兩個數使得和為sum。

    這樣看來遍歷需要O（n），再找兩個數需要O（n²）的複雜度，還是需要O（n³）。

    巧妙之處在於怎麼找另外兩個數。

    最最優美的地方就是，首先將給定的num排序。

    這樣我們就可以用兩個指針，一個指向頭，一個指向尾，去找這兩個數字，這樣的話，找另外兩個數時間複雜度就會從O（n²），降到O（n）。

    而怎麼保證不加入重複的list呢？

    要記得我們的nums已經有序了，所以只需要找到一組之後，當前指針要移到和當前元素不同的地方。其次在遍歷數組的時候，如果和上個數字相同，也要繼續後移。文字表述比較困難，可以先看下代碼。

    lo 為什麼是起始是 i+1?
    因為迴圈 是從 num[0] 開始跑, 所以要找其他兩數的 index 就是： lo要比他大1個index, hi從最右邊index
    所以回圈也只要跑到 < num.length-2 (其他兩數)

    step1: 先把資料做排序

    step2: 跑 for loop（num.length-2)

    step3: i == 0 （剛開始） 或 num[i] != num[i-1]) 才要跑

    step4: 初始 lo, hi, sum

    step5: while (lo < hi) {
           if (num[lo] + num[hi] == sum) { // 找 其他 2數 ＝ sum
               add 答案 :  res.add(Arrays.asList(num[i], num[lo], num[hi]));

               while (lo < hi && num[lo] == num[lo+1]) {
                            lo++;
               }
               while (lo < hi && num[hi] == num[hi-1]) {
                            hi--;
               }
               lo++;
               hi--;

           } else if (num[lo] + num[hi] < sum) {
                lo++;
           } else {
                hi--;
           }

           debug:
           先排序過： {-4. -1, -1, 0, 1, 2}
           i=0: sum = 0 - num[0] = 4  , lo = 1, hi = n-1 => 在 1~n-1的範圍內找出 兩數=sum = 4

           i=1: sum = 0 - num[1] = 1  , lo = 2, hi = n-1 => 在 2~n-1的範圍內找出 兩數=sum = 1

           ...以此類推


*/
    public List<List<Integer>> threeSum(int[] num) {

        // 一定要排序, 之後才能正常淘汰一樣的數字
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>();

        for (int i = 0; i < num.length-2; i++) {

            if (i == 0 || (num[i] != num[i-1])) {
                int lo = i+1;
                int hi = num.length-1;
                int sum = 0 - num[i]; // 0 - 目前某一數 ＝ sum = 其他2數和為

                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) { // 找 其他 2數 ＝ sum
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo+1]) {
                            lo++;
                        }
                        while (lo < hi && num[hi] == num[hi-1]) {
                            hi--;
                        }
                        lo++;
                        hi--;
                    } else if (num[lo] + num[hi] < sum) {
                        lo++;
                    } else {
                        hi--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String args[]) {
        int input[] = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> rs = new ThreeSum().threeSum(input);

        rs.stream().forEach(r -> System.out.println(r.toString()));

    }
}
