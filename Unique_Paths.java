/*
Unique Paths Total Accepted: 18304 Total Submissions: 58183 My Submissions
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?


Above is a 3 x 7 grid. How many possible unique paths are there?

Note: m and n will be at most 100.
*/

/*
State: f[m][n]: the step num from origin point to point[m][n]
Function: f[m][n] = f[m - 1][n] + f[m][n - 1]
Intialize: f[0][0] = 1; f[0][n] = 1; f[m][0] = 1; 
Answer: f[m - 1][n - 1]
*/
public class Solution {
    public int uniquePaths(int m, int n) {
        if ( m == 0 || n == 0) {
            return 0;
        }
        
        int[][] f = new int[m][n];
        for (int i = 0; i < m; i++) {
            f[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            f[0][i] = 1;
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        
        return f[m - 1][n - 1];
    }
}