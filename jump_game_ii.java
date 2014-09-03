/*
Jump Game II Total Accepted: 15761 Total Submissions: 63981 My Submissions
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
*/


/*
State: f[x] means the minimum number of jumps to the position x
Function: f[x] = min(f[y]) + 1 when y + A[y] >= x;
Initialize: f[0] = A[0]
Result:f[A.length - 1]
*/

public class Solution {
    public int jump(int[] A) {
        if (A == null || A.length == 0) {
             return 0;
        }
        
        int[] f = new int[A.length];
        f[0] = 0;
        for (int i = 1; i < A.length; i++) {
            int minVal = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (j + A[j] >= i && minVal > f[j] + 1) {
                    minVal = f[j] + 1;
                    break;//the num on the left point must lower than the num on the right point 
                }
            }
            f[i] = minVal;
        }
        
        return f[A.length - 1];
    }
}