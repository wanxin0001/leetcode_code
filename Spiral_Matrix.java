/*
Spiral Matrix Total Accepted: 13393 Total Submissions: 65072 My Submissions
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
*/

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0;
        int right = col - 1;
        int top = 0;
        int bottom = row - 1;
        
        while (top < bottom && left < right) {
            
            for (int i = left; i < right; i++) {
                result.add(matrix[top][i]);
            }
            for (int j = top; j < bottom; j++) {
                result.add(matrix[j][right]);
            }
            for (int i = right; i > left; i--) {
                result.add(matrix[bottom][i]);
            }
            for (int j = bottom; j > top; j--) {
                result.add(matrix[j][left]);
            }
            top++;
            bottom--;
            left++;
            right--;
            
        }
        
        if (top == bottom) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
        } else if (left == right) {
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][left]);
            }
        }
        
    
        
        return result;
        
        
    }
}