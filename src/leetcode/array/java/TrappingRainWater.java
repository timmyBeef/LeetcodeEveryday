package leetcode.array.java;

import java.util.Stack;

/*
    method1: two pointer

    time: O(n)
    space:O(1)


    method 2: not easy to write
    using stack to record index
    when should we caculate area? => when current height > stack's top elemnt height

    time complexity: O(n), space complexity: O(n) stack's size
 */
public class TrappingRainWater {

    // method 1
    // find lower height (left or right)
    // record left Max height or  right max height, res+= (leftmax or rightmax) - h[left or right]
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        int leftMax = 0;
        int rightMax = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                res += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                res += rightMax - height[right];
                right--;
            }
        }
        return res;
    }

    public int trapByStack(int[] height) {
        if (height == null) return 0;

        Stack<Integer> s = new Stack<>(); // stack stores index
        int curr = 0; // current index
        int maxWater = 0; // result

        while (curr < height.length) {
            // stack is empty ot current <= stack top, push current
            if (s.isEmpty() || height[curr] <= height[s.peek()]) {
                s.push(curr++);
            } else {
                int top = s.pop(); // current height > stack top's height, pop current
                int water = 0;

                if (!s.isEmpty()) { //stack is not empty, then we caculate area
                    int distance = curr - s.peek() - 1;
                    int minHeight = Math.min(height[s.peek()], height[curr]) - height[top]; // find the offset with 1. lowest height between curr and stack top's height, 2. pop's element hight
                    water = distance * minHeight;
                }
                //stack is empty, water is 0

                maxWater += water;
            }
        }
        return maxWater;
    }
}
