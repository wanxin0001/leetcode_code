/*
Surrounded Regions Total Accepted: 13363 Total Submissions: 93823 My Submissions
Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
*/

public class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < board[0].length; i++) {
            bfs(board, 0, i);
            bfs(board, m - 1, i);
        }
        
        for (int i = 1; i < board.length; i++) {
            bfs(board, i, 0);
            bfs(board, i, n - 1);
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'D') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
        
        return;
    }
    
    private void bfs(char[][] board, int x, int y) {
        if (board[x][y] != 'O' ) {
            return;
        }
        int[][] direction = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        int idx =  x * board[0].length + y;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(idx);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            x = cur / board[0].length;
            y = cur % board[0].length;
            if (board[x][y] == 'O') {
                board[x][y] = 'D';
                for (int i = 0; i < 4; i++) {
                    int xIdx = x + direction[i][0];
                    int yIdx = y + direction[i][1];
                    if (xIdx >= 0 && xIdx < board.length && yIdx >= 0 && yIdx < board[0].length) {
                        idx = (y + direction[i][1])  + (x + direction[i][0]) * board[0].length;
                        queue.add(idx);
                    }
                }
            }
            
        }
        
        return;
    }
}