/*

Word Break II Total Accepted: 15323 Total Submissions: 93178 My Submissions
Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].*/

public class Solution {
    public List<String> wordBreak(String s, Set<String> dict) {
        List<String> result = new ArrayList<String>();
        if (s == null || s.length() == 0 || dict.isEmpty()) {
            return result;
        }
        StringBuilder tmp = new StringBuilder();
        helper(result, tmp, dict, s);
        
        return result;
    }
    
    private void helper(List<String> result, StringBuilder tmp, Set<String> dict, String s) {
        if (s.equals("")) {
            tmp.delete(0, 1);
            result.add(new String(tmp.toString()));
            tmp.insert(0, " ");
            return;
        }
        
        for (int i = s.length() - 1; i >= 0; i--) {
            if (dict.contains(s.substring(i, s.length()))) {
                helper(result, tmp.insert(0, s.substring(i, s.length())).insert(0, " "), dict, s.substring(0, i));
                tmp.delete(0, 1);
                tmp.delete(0, s.substring(i, s.length()).length());
            }
        }
        return;
    }
}