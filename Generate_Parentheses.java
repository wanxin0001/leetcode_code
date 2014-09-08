/*
Generate Parentheses Total Accepted: 19484 Total Submissions: 61901 My Submissions
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
*/

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        if (n <= 0) {
            return result;
        }
        String tmp = "";
        helper(result, tmp, n, n);
        return result;
    }
    
    private void helper(List<String> result, String tmp, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(new String(tmp));
            return;
        }
        
        if (left > 0) {
            helper(result, tmp + "(", left - 1, right);
        }
        if (right > left && right >0) {
            helper(result,tmp + ")", left, right - 1);
        }
    }
}