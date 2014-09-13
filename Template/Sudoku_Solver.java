/*
Sudoku Solver Total Accepted: 12206 Total Submissions: 58784 My Submissions
Write a program to solve a Sudoku puzzle by filling the empty cells.

Empty cells are indicated by the character '.'.

You may assume that there will be only one unique solution.


A sudoku puzzle...


...and its solution numbers marked in red.
*/

public class Solution {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return;
        }
        ArrayList<Integer> empty = new ArrayList<Integer>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    empty.add(i * 9 + j);
                }
            }
        }
        
        helper(board, empty, 0, empty.size());
    }
    
    private boolean helper(char[][] board, ArrayList<Integer> empty,  int cur, int n) { // we need to boolean because we need it give us the true result;
        if (cur == n) {
            return true;
        }
        
        int index = empty.get(cur);
        int row = index / 9; 
        int col = index % 9;
        for (int v= 1; v <= 9; v++) {
            if (isValid(v, row, col, board)) {
                board[row][col] = (char) (v + '0');
                if (helper(board, empty, cur + 1, n)) {
                    return true;
                }
                board[row][col] = '.';
            }
        }
        return false;
    }
    
    private boolean isValid(int v, int row, int col, char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] - '0' == v || board[i][col] - '0' == v) {
                return false;
            }
            
            int row_s = 3 * (row / 3) + i / 3;
            int col_s = 3 * (col / 3) + i % 3;
            if (board[row_s][col_s] - '0' == v)  {
                return false;
            }
        }
        return true;
    }
}

