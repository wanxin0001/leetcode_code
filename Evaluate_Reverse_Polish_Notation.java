/*
Evaluate Reverse Polish Notation Total Accepted: 23397 Total Submissions: 117373 My Submissions
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
*/

public class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length <= 0 || tokens.length == 2) {
            return -1;
        }
        if (tokens.length == 1 && !isSymbol(tokens[0])) {
            return Integer.parseInt(tokens[0]);
        } else if (tokens.length == 1) {
            return Integer.MIN_VALUE;
        }
        Stack<Integer> stack = new Stack<Integer>();
        
        for (int i = 0; i < tokens.length; i++) {
            if (isSymbol(tokens[i])) {
                if(!compute(tokens[i], stack)) {
                    return -1;
                }
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        
        if (stack.size() == 1) {
            return stack.pop();
        } else {
            return -1;
        }
    }
    
    private boolean isSymbol(String token) {
        if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
            return true;
        } else {
            return false;
        }
    }
    
    private boolean compute(String symbol, Stack<Integer> stack) {
        
        int result = 0;
        if (!stack.isEmpty()) {
            result = stack.pop();
        } else {
            return false;
        }
    
        
        int prev = 0;
        if (!stack.isEmpty()) {
            prev = stack.pop();
        } else {
            return false;
        }
        int val = 0;
        if (symbol.equals("+")) {
            val = result + prev;
            stack.push(val);
            return true;
        } else if (symbol.equals("-")) {
            val = prev - result;
            stack.push(val);
            return true;
        } else if (symbol.equals("*")) {
            val = prev * result;
            stack.push(val);
            return true;
        } else if (symbol.equals("/")) {
            if (result == 0) {
                return false;
            }
            val = prev / result;
            stack.push(val);
            return true;
            
        }
        
        return false;
    }
    
}