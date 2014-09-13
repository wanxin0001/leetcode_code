/*
Maximal Rectangle Total Accepted: 11265 Total Submissions: 52151 My Submissions
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
*/

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        
        int[][] f = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0) {
                    f[i][j] = matrix[i][j] == '1' ? 1 : 0;
                } else {
                    if (matrix[i][j] == '0') {
                        f[i][j] = 0;
                    } else {
                        if (f[i - 1][j] != 0) {
                            f[i][j] = f[i - 1][j] + 1;
                        } else {
                            f[i][j] = 1;
                        }
                        
                    }
                }
            }
        }
        
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            int val = helper(f[i]);
            max = Math.max(max, val);
        }
        
        return max;
    }
    
    private int helper(int[] array) {
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for (int i = 0; i < array.length + 1; i++) {
            int cur = (i == array.length) ? -1 : array[i];
            while (!stack.isEmpty() && cur <= array[stack.peek()]) {
                int h = array[stack.pop()];
                int w = stack.isEmpty() ? i : i - 1 - stack.peek();
                
                max = Math.max(h * w, max);
            }
            stack.push(i);
        }
        
        return max;
    }
}