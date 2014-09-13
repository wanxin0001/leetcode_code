/*
N-Queens II Total Accepted: 12962 Total Submissions: 38880 My Submissions
Follow up for N-Queens problem.

Now, instead outputting board configurations, return the total number of distinct solutions.


*/

public class Solution {
    private int result = 0;
    public int totalNQueens(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] loc = new int[n];
        helper(n, loc, 0);
    
        return result;
    }
    
    
    
    private void helper(int n, int[] loc, int cur) {
        if (n == cur) {
            result++;
            return; // Need 
        }
        for (int i = 0; i < loc.length; i++) {
            loc[cur] = i;
            if (isValid(cur, loc)) {
                helper(n, loc, cur + 1);
            }
        }
    }
    
    private boolean isValid(int cur, int[] loc) {
        for (int i = 0; i < cur; i++) {
            if (loc[i] == loc[cur] || Math.abs(i - cur) == Math.abs(loc[i] - loc[cur])) {
                return false;
            }
        }
        
        return true;
    }
}