/*
Reverse Words in a String Total Accepted: 25387 Total Submissions: 181230 My Submissions
Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".
*/
public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.trim().length() == 0) {
            return "";
        }
        
        Stack<String> stack = new Stack<String>();
        for (String item: s.split(" +")) {
            stack.push(item);
        }
        
        String result = "";
        while(stack.size() > 0 ) {
            if(stack.peek().length() != 0) {
                result += stack.pop() + " ";
            }
            else{
                stack.pop();
            }
            
        }
        
        return result.substring(0, result.length() - 1); 
        
    }
}