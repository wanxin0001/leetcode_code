/*
Unique Paths II Total Accepted: 12544 Total Submissions: 45227 My Submissions
Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Note: m and n will be at most 100.
*/

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid[0] == null) {
            return 0;
        }
        
        int[] matrix = new int[obstacleGrid[0].length];
        if (obstacleGrid[0][0] == 1) {
            matrix[0] = 0;
        }
        else {
            matrix[0] = 1;
        }
        
        for (int i = 0; i < obstacleGrid.length; i++) {
            int j = 0;
            if(j == 0 && obstacleGrid[i][j] == 1) {  //NOTICE: NEEDED
                matrix[j] = 0;
            }
            for (j = 1; j< obstacleGrid[0].length; j++) {
                if (i == 0) {
                    matrix[j] = (obstacleGrid[i][j] == 0) ? matrix[j - 1] : 0; //NOTICE: IS matrix[j - 1], rather than 1
                }
                else {
                    matrix[j] = (obstacleGrid[i][j] == 0) ? matrix[j] + matrix[j - 1] : 0;
                }
            }
        }
        
        return matrix[obstacleGrid[0].length -1];
    }
}