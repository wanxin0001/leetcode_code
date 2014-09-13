/*
Largest Rectangle in Histogram Total Accepted: 15750 Total Submissions: 73910 My Submissions
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.


Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example,
Given height = [2,1,5,6,2,3],
return 10.
*/
public class Solution {
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for (int i = 0; i < height.length + 1; i++) {
            int cur = (i == height.length) ? -1 : height[i];
            while (!stack.isEmpty() && cur <= height[stack.peek()]) {
                int h = height[stack.pop()];
                int w = 0;
                if (stack.isEmpty()) {
                    w = i;
                } else {
                    w = i - 1 - stack.peek();
                }
                
                max = Math.max(max, h * w);
            }
            
            stack.push(i);
        }
        
        
        return max;
    }
}