package leetcode;

//用 bsearch

class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        // Assume input is already sorted.
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum < target) {
                i++;
            } else if (sum > target) {
                j--;
            } else {
                return new int[] { i + 1, j + 1 };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String args[]) {
        int[] test = {2, 7, 11, 15};
        int[] rs = new TwoSum2().twoSum(test, 9);
        System.out.println(rs[0] + "," + rs[1]);
    }
}


