/*
Count and Say Total Accepted: 15069 Total Submissions: 55148 My Submissions
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
*/
public class Solution {
    public String countAndSay(int n) {
        if (n <= 0) {
            return "";
        }
        String result = "1";
        for (int i = 2; i <= n; i++) {
            result = helper(result);
        }
        
        return result;
    }
    
    private String helper(String input) {
        int last = 0;
        String result = "";
        
        for (int i = 0; i < input.length() ; i++) {
            if (i < input.length() - 1 && input.charAt(i) == input.charAt(i + 1)) {
                continue; // Not i++;
            } else {
                result += Integer.toString(i - last + 1) + Character.toString(input.charAt(i));
                last = i + 1;
            }
        }
        
        if (last != input.length()) {
            result += Integer.toString(input.length() - last) + Character.toString(input.charAt(last));
        }
        
        return result;
    }
}