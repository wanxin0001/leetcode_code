/*
Valid Sudoku Total Accepted: 13598 Total Submissions: 48699 My Submissions
Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


A partially filled sudoku which is valid.

Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
*/

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        if (board == null || board.length != 9 || board[0].length != 9) {
            return false;
        }
        ArrayList<Integer> empty = new ArrayList<Integer>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                } else {
                    
                    if (!isValid(board[i][j] - '0', i, j, board)) {
                        return false;
                    }
                   
                }
            }
        }
        
        return true;
    }
    
    
    
    private boolean isValid(int v, int row, int col, char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (i != col && board[row][i] - '0' == v || i != row && board[i][col] - '0' == v) {
                return false;
            }
            
            int row_s = 3 * (row / 3) + i / 3;
            int col_s = 3 * (col / 3) + i % 3;
            if (board[row_s][col_s] - '0' == v && !(row_s == row && col_s == col))  {
                return false;
            }
        }
        return true;
    }
}

