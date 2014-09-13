import java.util.*;
public class Solution {
    public static void main(String[] str) {
        Solution obj = new Solution();
        int[] array = {0,1,0,1};
        System.out.println(obj.largestRectangleArea(array));
    }
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        left[0] = 0;
        
        right[right.length - 1] = right.length - 1;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        for (int i = 1; i < left.length; i++) {
            while (!stack.isEmpty()) {
                int index = stack.peek();
                if (height[index] < height[i]) {
                    left[i] = index + 1;
                    
                        stack.push(i);
                    
                    break;
                } else if (height[index] == height[i]) {
                    left[i] = index;
                    break;
                }
                else
                {
                    stack.pop();
                    continue;
                }
             }
            if (stack.isEmpty()) {
                left[i] = i;
                stack.push(i);
                
            }
        }
        
        stack.clear();
        stack.push(right.length - 1);
        for (int i = right.length - 2; i >= 0; i--) {
            while (!stack.isEmpty()) {
                int index = stack.peek();
                if (height[index] < height[i]) {
                    right[i] = index - 1;
                    
                    stack.push(i);
                    
                    break;
                } else if (height[index] == height[i]) {
                    right[i] = i;
                    break;
                }
                
                else{
                    
                    stack.pop();
                    continue;
                }
            }
            
            if (stack.isEmpty()) {
                right[i] = right.length - 1;
                stack.push(i);
                
            }
            
        }
        
        int maxArea = 0;
        for (int i = 0; i < left.length; i++) {

            maxArea = Math.max(maxArea, (right[i] + 1 - left[i]) * height[i]);
            System.out.println(i + " " + left[i] + " " +right[i] + " " + maxArea);
        }
        
        return maxArea;
    }
}