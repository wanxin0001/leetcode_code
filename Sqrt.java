/*
Sqrt(x) Total Accepted: 21628 Total Submissions: 97119 My Submissions
Implement int sqrt(int x).

Compute and return the square root of x.
*/
public class Solution {
    public int sqrt(int x) {
        long high = x;
        long low = 0;
        while (high >= low) { // it must be >= because when high equals low, maybe x > high * high. So we need to check again.
            long mid = low + (high - low) / 2;
            if (x == mid * mid) {
                return (int) mid;
            }
            if (x > mid * mid) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return (int) high;
    }
}