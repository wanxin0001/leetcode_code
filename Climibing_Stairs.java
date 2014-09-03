/*
Climbing Stairs Total Accepted: 22020 Total Submissions: 64953 My Submissions
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
*/

/*
State: f[i] means that the total steps when climbing to pos i 
Function: f[i] = f[i - 1] + f[i - 2];
Initinalize:f[0] = 0; f[1] = 1; f[2] = 2; 
Result: f[n]
*/

public class Solution {
    public int climbStairs(int n) {
        if (n <= 2) { //Notice it also covers n == 1 or n == 2
            return n;
        }
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 1;
        f[2] = 2;
        
        for (int i = 3; i <= n; i++) {
            f[i] = f[i - 1] + f[i -2];
        }
    
        
        return f[n];
    }
}