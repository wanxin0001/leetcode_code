/*
Pow(x, n) Total Accepted: 21887 Total Submissions: 84449 My Submissions
Implement pow(x, n).
*/

public class Solution {
    public double pow(double x, int n) {
        boolean isNeg = false;
        if (n < 0) {
            isNeg = true;
            n = -n;
            if (x == 0) {
                return -1;
            }
        }
        if (n == 1) {
            return isNeg ? 1 / x : x;
        } else if (n == 0) {
            return 1;
        }
        if (n % 2 == 0) {
            return isNeg ? 1 / (pow(x * x, n / 2)) : (pow(x * x, n /2));
        } else {
            return isNeg ? 1 / (pow(x * x, n / 2) * x) : (pow(x * x, n / 2) * x);
        }
    }
}