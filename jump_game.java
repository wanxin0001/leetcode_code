/*
Jump Game Total Accepted: 18237 Total Submissions: 67150 My Submissions
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.


*/

/*
State: f[x] means whether you can jump to the position of x
Funcition: f[x] = OR (f[y] == true && y + A[y] >= x)
Initinalize:f[x] = true
Answer:f[A.length -1]
*/

public class Solution {
    public boolean canJump(int[] A) {
        if (A == null || A.length == 0) {
            return false;
        }
        
        boolean[] f = new boolean[A.length];
        f[0] = true;//Very Important!!!
        for (int i = 1; i < f.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                    if (j + A[j] >= i && f[j] == true) {
                        f[i] = true;
                        break;
                    }
                
            }
        }
        return f[A.length - 1];
    }
}