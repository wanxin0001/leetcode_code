/*
Remove Duplicates from Sorted Array Total Accepted: 24988 Total Submissions: 77104 My Submissions
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array A = [1,1,2],

Your function should return length = 2, and A is now [1,2].
*/

public class Solution {
    public int removeDuplicates(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int len = 1;
        int lastVal = A[0];
        int lastPtr = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] == lastVal) {
                continue;
            } else {
                A[lastPtr + 1] = A[i];
                len++;
                lastPtr++;
                lastVal = A[i];
            }
        }
        
        return len;
    }
}