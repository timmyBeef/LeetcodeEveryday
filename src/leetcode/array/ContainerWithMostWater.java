package leetcode.array;
/*
    11. Container With Most Water
    https://leetcode.com/problems/container-with-most-water/

 */
public class ContainerWithMostWater {

    // O(n), O(1)
    public int maxArea(int[] height) {
        int maxArea = 0;
        int i = 0;
        int j = height.length -1;

        while(i < j) {
            int minHeight = height[i] < height[j] ? height[i++] : height[j--];
            int area = (j - i + 1) * minHeight; //here why plus one, because we do i++ or j-- first, if i++, -i so plus1, if j--, j, plus1, too
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
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
