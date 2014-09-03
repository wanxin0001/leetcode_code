/*
Word Break Total Accepted: 21613 Total Submissions: 102849 My Submissions
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
*/

/*
State:f[n] means the string s from 0 to n can be formed by a sequence of words.
Function:f[n] = OR (f[m] && string from (m + 1 to n) is a word)
Initialize:f[0] = true;
Answer:f[n]
*/

public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        if (dict.size() == 0 || s == null || s.length() == 0) {
            return false;
        }
        
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;
        
        for (int i = 1; i < f.length; i++) {
            for (int j = 0; j < i; j++) {//j starts from 0, rather than 1
                if (f[j] && dict.contains(s.substring(j, i))) {
                    f[i] = true;
                    break;
                }
            }
        }
        
        return f[f.length - 1];
    }
}