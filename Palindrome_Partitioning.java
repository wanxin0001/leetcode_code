/*
Palindrome Partitioning Total Accepted: 15730 Total Submissions: 61003 My Submissions
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]
*/
public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> tmp = new ArrayList<String>();
        
        if (s == null || s.length() == 0) {
            return result;
        }
        
        dfs(result, tmp, s);
        return result;
    }
    
    private void dfs(List<List<String>> result, List<String> tmp, String s) {
        if (s.length() == 0) {
            result.add(new ArrayList<String>(tmp));
            return;
        }
        
        for (int i = 1; i<= s.length(); i++) {
            if (isPartition(s.substring(0, i)) ){
                tmp.add(s.substring(0, i));
                dfs(result, tmp, s.substring(i));
                tmp.remove(tmp.size() - 1);
            }
        }
    }
    
    private boolean isPartition(String s) {
        int left = 0;
        int right = s.length() - 1;
        while(left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
            
            
        }
        return true;
    }
}