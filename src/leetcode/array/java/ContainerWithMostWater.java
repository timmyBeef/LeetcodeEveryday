package leetcode.array.java;
/*
    11. Container With Most Water
    https://leetcode.com/problems/container-with-most-water/

    time: O(n)
    space: O(1)
 */
public class ContainerWithMostWater {
    // 取小的高產生面積（這樣才能裝水）, 但移動時要留下高的, 移動矮的, 才是最佳化

    public int maxArea(int[] height) {
        int maxArea = 0;
        int i = 0;
        int j = height.length -1;

        while(i < j) {
            int minHeight = height[i] < height[j] ? height[i++] : height[j--];
            int area = (j - i + 1) * minHeight; // why plus one? because we do i++ or j-- first, if i++, do -i so plus one, if j--, do +j, plus one, too
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    // 比較好懂的版本
    public int maxAreaMoreStrait(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int res = 0;
        while (l < r) {
            res = Math.max(res, Math.min(height[l], height[r])*(r - l));
            if (height[r] > height[l]) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }


    //brute force O(n^2)
    public int maxAreaBruteForce(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i+1; j < height.length; j++) {
                int area = (j - i) * Math.min(height[i], height[j]);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }
}
