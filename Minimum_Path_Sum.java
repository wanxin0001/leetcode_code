/*
Minimum Path Sum Total Accepted: 14501 Total Submissions: 46582 My Submissions
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
*/

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