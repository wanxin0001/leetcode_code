/*
Restore IP Addresses Total Accepted: 13816 Total Submissions: 67488 My Submissions
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",


*/

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return result;
        }
        
        String tmp = "";
        helper(result, tmp, s, 0, 0);
        
        return result;
    }
    
    private void helper(List<String> result, String tmp, String s, int pos, int num) {
        if (num == 4 && pos == s.length()) {
            result.add(new String(tmp));
            return;
        }
        
        for (int i = 1; i <= 3 && pos + i <= s.length(); i++) {
            if (isValid(s.substring(pos, pos + i))) {
                if (num != 3) {
                    helper(result, tmp + s.substring(pos, pos + i) + ".", s, pos + i, num+1);
                } else {
                    helper(result, tmp + s.substring(pos, pos + i), s, pos + i, num+1);
                }
            }
        }
    }
    
    private Boolean isValid(String str) {
        if (Integer.toString(Integer.parseInt(str)).length() != str.length()) {
            return false;
        }
        if (Integer.parseInt(str) >=0 && Integer.parseInt(str) <= 255) {
            return true;
        }
        
        return false;
    }
}