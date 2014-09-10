/*
Valid Palindrome Total Accepted: 19384 Total Submissions: 84536 My Submissions
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
*/

public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null) {
            return true;
        }
        s = s.trim();
        s = s.toLowerCase();
        if (s.length() == 0) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (!(s.charAt(left) >= 'a' && s.charAt(left) <= 'z') &&!(s.charAt(left) >= '0' && s.charAt(left) <= '9')) {
                left++;
                continue;
            }
            if (!(s.charAt(right) >= 'a' && s.charAt(right) <= 'z') &&!(s.charAt(right) >= '0' && s.charAt(right) <= '9')) {
                right--;
                continue;
            }
            
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
}