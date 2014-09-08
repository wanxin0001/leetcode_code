/*
Valid Parentheses Total Accepted: 18018 Total Submissions: 63434 My Submissions
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/

public class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        
        int len = s.length();
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    if (s.charAt(i) == ')' && stack.pop() == '(') {
                        continue;
                    }  
                    else if (s.charAt(i) == '}' && stack.pop() == '{') {
                        continue;
                    }
                    else if (s.charAt(i) == ']' && stack.pop() == '[') {
                        continue;
                    }
                    return false;
                }
            }
        }
        
        if (stack.isEmpty()) {
            return true;
        }
        
        return false;
    }
}