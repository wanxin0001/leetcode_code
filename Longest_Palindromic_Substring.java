/*
Longest Palindromic Substring Total Accepted: 18900 Total Submissions: 90865 My Submissions
Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
*/

public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        
        int len = s.length();
        int maxVal = Integer.MIN_VALUE;
        String result = "";
        for (int i = 0; i < len; i++) {
            int val = getResult(s, i);
            if (maxVal < val) {
                maxVal = val;
                if (val % 2 != 0) {
                    result = s.substring(i - val / 2, i + val / 2 + 1);
                } else {
                    result = s.substring(i - val / 2, i + val / 2);
                }
            }
        }
        return result;
    }
    
    private int getResult(String s, int i) {
        //odd
        int sizeOdd = 1;
        int left = 1;
        int right = 1;
        while (i - left >= 0 && i + right < s.length() && s.charAt(i - left) == s.charAt(i + right)) {
            sizeOdd += 2;
            left++;
            right++;
        }
        
        //even
        int sizeEven = 0;
        left = 1;
        right = 0;
        while(i - left >=0 && i + right < s.length() && s.charAt(i - left) == s.charAt(i + right)) {
            sizeEven +=2;
            left++;
            right++;
        }
        
        return Math.max(sizeOdd, sizeEven);
    }
}