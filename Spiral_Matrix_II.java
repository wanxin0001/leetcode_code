/*
Spiral Matrix II Total Accepted: 13349 Total Submissions: 43386 My Submissions
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]

*/

public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if (n <= 0) {
            return matrix;
        }
        
        int layer = 0;
        int num = 1;
        while (n > 0) {
            for (int i = 0; i < n - 1; i++) {
                matrix[layer][layer + i] = num;
                num++;
            }
            for (int j = 0; j < n - 1; j++) {
                matrix[layer + j][n - 1 + layer] = num;
                num++;
            }
            for (int i = n - 1; i > 0; i--) {
                matrix[n - 1 + layer][i + layer] = num;
                num++;
            }
            for (int j = n - 1; j > 0; j--) {
                matrix[layer + j][layer] = num;
                num++;
            }
            n -= 2;
            layer++;
        }
        
        if (n == -1) { //not n == 1
            matrix[matrix.length / 2][matrix.length / 2] = num;
        }
        
        return matrix;
    }
}