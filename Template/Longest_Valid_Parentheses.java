
/*
Longest Valid Parentheses Total Accepted: 15290 Total Submissions: 78134 My Submissions
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.


*/

public class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        int maxLen = 0;
        int accumulatedLen = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    accumulatedLen = 0;
                } else {
                    int pos = stack.pop();
                    int length = i - pos + 1;
                    
                    if (stack.isEmpty()) {
                        accumulatedLen += length;
                        length = accumulatedLen;
                    } else {
                        length = i - stack.peek(); //care that. very important
                    }
                    maxLen = Math.max(maxLen, length);
                }
                
                
            }
        }
        
        return maxLen;
    }
}