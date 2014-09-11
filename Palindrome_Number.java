/*
Palindrome Number Total Accepted: 20868 Total Submissions: 71818 My Submissions
Determine whether an integer is a palindrome. Do this without extra space.

click to show spoilers.

Some hints:
Could negative integers be palindromes? (ie, -1)

If you are thinking of converting the integer to string, note the restriction of using extra space.

You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

There is a more generic way of solving this problem.


*/

public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int size = 0;
        int cur = x;
        while (cur != 0) {
            size++;
            cur /= 10;
        }
        
         long origin = (long) x;
         long now = 0;
         while (size > 0) {
             size--;
             long val = origin % 10; //not int
             now = now * 10 + val;
             origin = origin / 10;
             
         }
         
         if (now == x) { // Notice: not origin
             return true;
         } else {
             return false;
         }
         
    }
}