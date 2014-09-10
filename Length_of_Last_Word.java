/*
Length of Last Word Total Accepted: 17775 Total Submissions: 60362 My Submissions
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.
*/

public class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        String[] items = s.split(" ", -1);
        
        for(int i = items.length - 1; i >= 0 ; i--) {
            if (items[i].equals("")) {
                continue;
            }
            return items[i].length();
        }
        
        return 0;
    }
}