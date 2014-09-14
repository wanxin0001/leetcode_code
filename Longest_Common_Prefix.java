/*
Longest Common Prefix Total Accepted: 17766 Total Submissions: 65353 My Submissions
Write a function to find the longest common prefix string amongst an array of strings.
*/
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int len = Integer.MAX_VALUE;
        String minWord = "";
        for (String str : strs) {
            if (str.length() < len) {
                minWord = str;
                len = str.length();
            }
        }
        
        int pos = helper(strs, 0, minWord.length(), minWord);
        return minWord.substring(0, pos);
    }
    
    private int helper(String[] strs, int start, int end, String word) {
        if (start <= end ) {
            int mid = (start + end) / 2;
            String s = word.substring(0, mid);
            
            if (isValid(strs, s)) {
                return Math.max(helper(strs, mid + 1, end, word), mid);
            } else {
                return helper(strs, start, mid - 1, word);
            }
        } else {
            return 0;
        }
        
        
        
        
    }
    private boolean isValid(String[] strs, String s) {
        for (String str : strs) {
            if (!str.substring(0, s.length()).equals(s)) {
                return false;
            }
        }
        return true;
    }
}