/*
Unique Paths II

 
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
/*
State: f[x][y] means the path num from origin point to the point(x,y)
Function: 
    f[x][y] = f[x - 1][y] + f[x][y - 1] if obstacleGrid[x][y] == 0
            = 0 if obstacleGrid[x][y] == 0
Initialize: f[0][i] = 1 and f[i][0] = 1 if obstacleGrid[x][y] ==0
Answer: f[x - 1][y - 1]
*/
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        int[][] f = new int[obstacleGrid.length][obstacleGrid[0].length];
        
        if (obstacleGrid[0][0] == 0) {
            f[0][0] = 1;
        } else {
            return 0;
        }
        
        for (int i = 1; i < f[0].length; i++) {
            if (obstacleGrid[0][i] == 0 && f[0][i - 1] != 0) {
                f[0][i] = 1;
            } else {
                f[0][i] = 0;
            }
        }
        
        for (int i = 1; i < f.length; i++) {
            if (obstacleGrid[i][0] == 0 && f[i - 1][0] != 0) {
                f[i][0] = 1;
            } else {
                f[i][0] = 0;
            }
        }
        
        for (int i = 1; i < f.length; i++) {
            for (int j = 1; j < f[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    f[i][j] = 0;
                } else {
                    f[i][j] = f[i - 1][j] + f[i][j - 1];
                }
            }
        }
        
        return f[f.length - 1][f[0].length - 1];
    }
}