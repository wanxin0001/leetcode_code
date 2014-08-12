/*
Divide Two Integers Total Accepted: 14405 Total Submissions: 88383 My Submissions
Divide two integers without using multiplication, division and mod operator
*/
public class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        
        boolean negative = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0) ? true : false;
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        int result = 0;
        while(a >= b) {
            int shift = 0; 
            while ((b << shift) <= a) {
                shift++;
            }
            result += 1 << (shift - 1);
            a = a - (b  << (shift - 1));
        }
        
        return negative ? -result : result;
    }
}