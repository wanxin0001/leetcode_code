/*
Wildcard Matching Total Accepted: 12567 Total Submissions: 91086 My Submissions
Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false
*/

public class Solution {
    public boolean isMatch(String s, String p) {
        int sPtr = 0, pPtr = 0, match = -1, starIdx = -1;
        while (sPtr < s.length()) {
            if (pPtr < p.length() && (p.charAt(pPtr) == '?' || p.charAt(pPtr) == s.charAt(sPtr))) {
                sPtr++;
                pPtr++;
            } else if (pPtr < p.length() && p.charAt(pPtr) == '*') {
                match = sPtr;
                starIdx = pPtr;
                pPtr++;
                
            } else if (starIdx != -1) {
                pPtr = starIdx + 1;
                match++;
                sPtr = match;
            } else {
                return false;
            }
        }
        
        while (pPtr < p.length() && p.charAt(pPtr) == '*') {
            pPtr++;
        }
        
        return pPtr == p.length();
    }
}