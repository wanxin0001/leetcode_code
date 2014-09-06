/*
First Missing Positive Total Accepted: 16157 Total Submissions: 71773 My Submissions
Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.
*/

public class Solution {
    public int firstMissingPositive(int[] A) {
        if (A == null || A.length == 0) {
            return 1;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        int minVal = Integer.MAX_VALUE;
        for ( int i = 0; i < A.length; i++) {
            set.add(A[i]);
            if (minVal > A[i] && A[i] > 0) {
                minVal = A[i];
            }
        }
        if (minVal > 1) {
            return 1;
        } else {
            while(++minVal != 0) {
                if (!set.contains(minVal)) {
                    return minVal;
                }
            }
        }
        
        return 1;
    }
}