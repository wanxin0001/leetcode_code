/*
Remove Duplicates from Sorted Array II Total Accepted: 18594 Total Submissions: 60729 My Submissions
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array A = [1,1,1,2,2,3],

Your function should return length = 5, and A is now [1,1,2,2,3].
*/

public class Solution {
    public int removeDuplicates(int[] A) {
        if (A == null) {
            return 0;
        }
        if (A.length <= 2) {
            return A.length;
        }
        
        int len = 1;
        int lastVal = A[0];
        int lastPtr = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] == lastVal) {
                while (i < A.length - 1 && A[i] == A[i + 1]) {
                    i++;
                }
                A[lastPtr + 1] = A[i]; 
                lastPtr += 1;
                len++;
            } else {
                lastVal = A[i];
                A[lastPtr + 1] = A[i];
                lastPtr++;
                len++;
            }
        }
        
        return len;
    }
}