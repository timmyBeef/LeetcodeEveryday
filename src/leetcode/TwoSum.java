package leetcode;

import java.util.HashMap;
import java.util.Map;

//用一個 map 把經過的值存起來, 檢查 (target - 下個值), 是不是存在 map 中了
// ,一一比對, 存在代表得到答案了, 回傳 index

class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("(numbers[i]):" + numbers[i]);

            int x = numbers[i];
            if (map.containsKey(target - x)) {
                System.out.println("(x):" + x);
                System.out.println("(target - x):" + (target - x));

                System.out.println("map:" + map.get(target - x));

                return new int[] { map.get(target - x), i  };
            }
            System.out.println("put:" + x + "," + i);
            map.put(x, i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String args[]) {
        int[] test = {2, 7, 11, 15};
        int[] rs = new TwoSum().twoSum(test, 9);
        System.out.println(rs[0]+ "," +rs[1]);
    }
}


