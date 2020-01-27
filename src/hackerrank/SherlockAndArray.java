package hackerrank;

import java.util.List;

/*
    https://www.hackerrank.com/challenges/sherlock-and-array/problem

    1. 求和 sum
    2. 計算 leftSum == sum - current - leftSum

    0 0 2 0
    when index 2, 0 = (2 - 2 - 0) => YES

    1 1 4 1 1
    when index 2, 2 = (8 - 4 - 2) => YES

    refer:
    https://gist.github.com/hxwang
 */
public class SherlockAndArray {

    static String balancedSums(List<Integer> arr) {

        // caculate total sum first
        int sum = arr.stream().mapToInt(Integer::valueOf).sum();

        int leftSum = 0; //left sum
        for(Integer current: arr){

            // left == right ( total - current value - left sum)
            if(leftSum == sum - current - leftSum){
                return "YES";
            }
            leftSum += current;
        }
        return "NO";
    }
}
