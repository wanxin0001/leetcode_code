/*
Palindrome Partitioning II Total Accepted: 12786 Total Submissions: 71306 My Submissions
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.


*/

public class Solution {
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        boolean[][] matrix = table(s);
        int[] cut = new int[s.length() + 1];
        cut[s.length()] = 0;
        int len = s.length();
        for (int i = len - 1; i >= 0; i--) {
            cut[i] = len - i;
            for (int j = i; j < len; j++) {
                if (matrix[i][j]) {
                    cut[i] = Math.min(cut[i], 1+ cut[j + 1]);
                }
            }
        }
        
        return cut[0] - 1;
    }
    
    private boolean[][] table(String s) {
        int len = s.length();
        boolean[][] matrix = new boolean[len][len];
        
        for (int i = 0; i < len; i++) {
            matrix[i][i] = true;
        }
        // to even
        for (int i = 0; i < len; i++) {
            int left = i - 1;
            int right = i + 1;
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                matrix[left][right] = true;
                left--;
                right++;
            }
        }
        
        //to odd
        for (int i = 0; i < len; i++) {
            int left = i - 1;
            int right = i;
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                matrix[left][right] = true;
                left--;
                right++;
            }
        }
        
        return matrix;
    }
}