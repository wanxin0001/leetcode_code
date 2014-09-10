/*
Rotate Image Total Accepted: 16462 Total Submissions: 52401 My Submissions
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?
*/

public class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        
        int len = matrix.length;
        int layer = 0;
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        
        while (left < right && top < bottom) {
            for (int i = 0; i < right - left; i++) {
                int tmp = matrix[i + top][left];
                matrix[top + i][left] = matrix[bottom][i + left];
                matrix[bottom][i + left] = matrix[bottom - i][right];
                matrix[bottom - i][right] = matrix[top][right - i];
                matrix[top][right - i] = tmp;
            }
            left++;
            right--;
            top++;
            bottom--;
            
        }
        return;
    }
}