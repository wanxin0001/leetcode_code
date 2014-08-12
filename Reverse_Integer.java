/*
Reverse Integer Total Accepted: 25835 Total Submissions: 64293 My Submissions
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321
*/
public class Solution {
    public int reverse(int x) {
        
        if (x == 0) {
            return 0;
        }
        boolean flag = false;
        if(x < 0) {
            x = -x;
            flag = true;
        }
        
        int result = 0;
        while(x != 0) {
            result = result * 10 +  (x % 10);
            x = x / 10;
        }
        
        return (flag == true) ? -result : result;
    }
}