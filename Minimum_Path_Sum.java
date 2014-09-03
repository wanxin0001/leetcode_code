/*
Minimum Path Sum Total Accepted: 14501 Total Submissions: 46582 My Submissions
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
*/

/*
State: f[x][y] means the distance between origin point and the point(x,y)
Function: f[x][y] = min(f[x][y - 1], f[x - 1][y]) + grid[x][y]
Initialize: f[0][0] = grid[0][0];
Answer: f[grid.length - 1][grid[0].length - 1]
*/

public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int[][] f = new int[grid.length][grid[0].length];
        
        f[0][0] = grid[0][0];
        for (int i = 1; i < grid[0].length; i++) {
            f[0][i] = f[0][i - 1] + grid[0][i];
        }
        
        for (int j = 1; j < grid.length; j++) {
            f[j][0] = f[j - 1][0] + grid[j][0];
        }
        
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + grid[i][j];
            }
        }
        
        return f[grid.length - 1][grid[0].length - 1];
    }
}




public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid[0].length == 0) {
            return 0;
        }
        int[] array = new int[grid[0].length];
        array[0] = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(j == 0 && i == 0) {
                    array[0] = grid[i][j];
                } else if (i==0 ) {
                    array[j] = array[j - 1] + grid[i][j];
                } else if (j == 0) {
                    array[j] = array[j] + grid[i][j];
                }
                else {
                    array[j] = grid[i][j] + Math.min(array[j], array[j - 1]);
                }
                
            }
        }
        
        return array[grid[0].length - 1];
    }
}