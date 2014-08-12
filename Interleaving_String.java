/*
Interleaving String Total Accepted: 12468 Total Submissions: 65457 My Submissions
Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.
*/


public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) {
            return false;
        }
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        
        boolean[][] matrix = new boolean[s1.length() + 1][s2.length() + 1];
        matrix[0][0] = true;
        
        for (int i = 1; i <= s1.length(); i++) {
            if (s1.charAt(i - 1) == s3.charAt(i - 1) && matrix[i - 1][0]) {
                matrix[i][0] = true;
            }
        }
        
        for (int i = 1; i <= s2.length(); i++) {
            if (s2.charAt(i - 1) == s3.charAt(i - 1) && matrix[0][i - 1]) {
                matrix[0][i] = true;
            }
        }
        
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s3.charAt(i + j - 1) && matrix[i - 1][j]) {
                    matrix[i][j] = true;
                } else if (s2.charAt(j - 1) == s3.charAt(i + j - 1) && matrix[i][j - 1]) {
                    matrix[i][j] = true;
                }
            }
        }
        
        return matrix[s1.length()][s2.length()];
    }
}

//Timeout
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        
        return helper(s1, 0, s2, 0, s3, 0);
    }
    
    private boolean helper(String s1, int ptr1, String s2, int ptr2, String s3, int ptr3) {
        if (ptr3 == s3.length()) {
            return true;
        }
        if (s1.length() == ptr1) {
            return s3.substring(ptr3).equals(s2.substring(ptr2));
        }
        if (s2.length() == ptr2) {
            return s3.substring(ptr3).equals(s1.substring(ptr1));
        }
        
        if (s3.charAt(ptr3) == s1.charAt(ptr1) && s3.charAt(ptr3) == s2.charAt(ptr2)) {
            return helper(s1, ptr1 + 1, s2, ptr2, s3, ptr3 + 1) || helper(s1, ptr1, s2, ptr2 + 1, s3, ptr3 + 1);
        }
        if (s3.charAt(ptr3) == s1.charAt(ptr1)) {
            return helper(s1, ptr1 + 1, s2, ptr2, s3, ptr3 + 1);
        }
        
        if (s3.charAt(ptr3) == s2.charAt(ptr2)) {
            return helper(s1, ptr1, s2, ptr2 + 1, s3, ptr3 + 1);
        }
        
        return false;
    }
}