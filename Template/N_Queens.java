/*
N-Queens Total Accepted: 14412 Total Submissions: 55531 My Submissions
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
*/

public class Solution {
    public List<String[]> solveNQueens(int n) {
        List<String[]> result = new ArrayList<String[]>();
        if (n <= 0) {
            return result;
        }
        String tmp = "";
        int[] loc = new int[n];
        
        helper(result, n, 0, loc);
        
        return result;
    
    }
    
    private void helper(List<String[]> result, int n, int cur, int[] loc) {
        if (cur == n) {
            print(result, loc);
            return;
        }
        
        for (int i = 0; i < n; i++) {
            loc[cur] = i;
            if (isValid(cur, loc)) {
                helper(result, n, cur + 1, loc);
            }
        }
    }
    
    private void print(List<String[]> result, int[] loc) {
        String[] tmp = new String[loc.length];
        for (int i = 0; i < loc.length; i++) {
            tmp[i] = "";
            for (int j = 0; j < loc.length; j++) {
                if (loc[i] == j) {
                    tmp[i] += "Q";
                } else {
                    tmp[i] +=".";
                }
            }
        }
        
        result.add(tmp);
        return;
    }
    
    private boolean isValid(int cur, int[] loc) {
        for (int i = 0; i < cur; i++) {
            if (loc[cur] == loc[i] || Math.abs(loc[cur] - loc[i]) == Math.abs(cur - i)) {
                return false;
            }
            
        }
        return true;
    }
}