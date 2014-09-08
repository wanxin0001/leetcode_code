/*
Letter Combinations of a Phone Number Total Accepted: 15990 Total Submissions: 60813 My Submissions
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.



Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.
*/

public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if (digits == null) {
            return result;
        }
        if (digits.length() == 0) {
            result.add("");
            return result;
        }
        String[] map = {"", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        int len = digits.length();
        String tmp = "";
        
        helper(result, tmp, digits, map, 0);
        
        return result;
    }
    
    private void helper(List<String> result, String tmp, String digits, String[] map, int pos) {
        if (tmp.length() == digits.length()) {
            result.add(new String(tmp));
            return;
        }
        
        for (int i = pos; i < digits.length(); i++) {
            String current = map[Integer.parseInt(digits.substring(i, i + 1)) - 1];
            for (int j = 0; j < current.length(); j++) {
                helper(result, tmp + current.charAt(j), digits, map, i + 1);// Notice i + 1 rather than pos
            }
        }
    }
}