/*
Word Search Total Accepted: 14392 Total Submissions: 72436 My Submissions
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/

public class Solution {
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return true;
        } else if (board == null || board.length == 0) {
            return false;
        }
        boolean[][] flag = new boolean[board.length][board[0].length];
        for (int m = 0; m < board.length; m++) {
            for (int n = 0; n < board[0].length; n++) {
                if (board[m][n] == word.charAt(0)) {
                    
                    if (helper(board, word, flag, m, n, 0)) {
                        return true;
                    }
                    
                    
                }
            }
        }
        return false;
    }
    
    private boolean helper(char[][] board, String word, boolean[][] flag, int m, int n, int pos) {
        if (pos == word.length()) {
            return true;
        }
        if (m < 0 || m >= board.length || n < 0 || n >= board[0].length) {
            return false;
        }
        if (flag[m][n] == false && board[m][n] == word.charAt(pos)) {
            flag[m][n] = true;
            boolean state =  helper(board, word, flag, m - 1, n, pos + 1) || helper(board, word, flag, m + 1, n, pos + 1) || helper(board, word, flag, m, n - 1, pos + 1) || helper(board, word, flag, m, n + 1, pos + 1);
            
            if (state) {
                return true;
            }
            flag[m][n] = false;
        } 
        
        return false;
        
    }
}