/*
Distinct Subsequences Total Accepted: 14979 Total Submissions: 60334 My Submissions
Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.
*/

/*
State: f[i][j] represents the num of the first i of S can form the first j of T
Function: f[i][j] = f[i - 1][j - 1] + f[i - 1][j] // S[i] == T[j]
          f[i][j] = f[i - 1][j] //S[i] != T[j]
Initialize: f[i][0] = 1; f[0][j] = 0;  f[0][0] = 1
Answer: f[S.length()][T.length()];
*/

public class Solution {
    public int numDistinct(String S, String T) {
        if (S == null || S.length() == 0) {
            return 0;
        } else if (T == null || T.length() == 0) {
            return 1;
        }
        
        int[][] f = new int[S.length() + 1][T.length() + 1];
        f[0][0] = 1;
        for (int i = 1; i < f.length; i++) {
            f[i][0] = 1;
        }
        
        for (int j = 1; j < f[0].length; j++) {
            f[0][j] = 0;
        }
        
        for (int i = 1; i <= S.length(); i++) {
            for (int j = 1; j <= T.length(); j++) {
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1] + f[i - 1][j];
                } else {
                    f[i][j] = f[i -1][j];
                }
            }
        }
        
        return f[S.length()][T.length()];
    }
}