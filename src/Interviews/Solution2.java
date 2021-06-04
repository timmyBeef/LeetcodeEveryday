package Interviews;

public class Solution2 {

    public int solution(int[] A) {
        // write your code in Java SE 8
        int res = 0;
        int preSum = 0;
        for (int i = 0; i < A.length - 1; i++) {
            preSum += A[i];
            if (preSum < 0 || preSum == 0 && A[i+1] < 0) {
                res++;
                preSum -= A[i];
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] a1 = new int[]{10,-10,-1,-1,10};
        int[] a2 = new int[]{-1,-1,-1,1,1,1,1};
        int[] a3 = new int[]{5,-2,-3,1};
        int[] a4 = new int[]{10,-12,-1,-1,10};
        int[] a5 = new int[]{5,-2,-2,-1};
        int[] a6 = new int[]{5,-1,5,-1,-1,-1};

        System.out.println(new Solution2().solution(a1));
        System.out.println(new Solution2().solution(a2));
        System.out.println(new Solution2().solution(a3));
        System.out.println(new Solution2().solution(a4));
        System.out.println(new Solution2().solution(a5));
        System.out.println(new Solution2().solution(a6));

    }
}
