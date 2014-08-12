/*
Edit Distance Total Accepted: 12458 Total Submissions: 49409 My Submissions
Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character
*/

public class Solution {
    public int minDistance(String word1, String word2) {
        if (word1 == null) {
            return word2.length();
        }
        if (word2 == null) {
            return word1.length();
        }
        
        int[][] matrix = new int[word1.length() + 1][word2.length() + 1];
        matrix[0][0] = 0;
        for (int i = 1; i <= word1.length(); i++) {
            matrix[i][0] = i;
        }
        
        for (int i = 1; i <= word2.length(); i++) {
            matrix[0][i] = i;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    matrix[i][j] = matrix[i - 1][j - 1];
                }
                else {
                    matrix[i][j] = 1 + Math.min(matrix[i - 1][j - 1], Math.min(matrix[i - 1][j], matrix[i][j - 1]));
                }
            }
        }
        
        return matrix[word1.length()][word2.length()];
    }
}