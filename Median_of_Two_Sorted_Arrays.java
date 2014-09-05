/*
Median of Two Sorted Arrays Total Accepted: 19348 Total Submissions: 111253 My Submissions
There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
*/

public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int len = A.length + B.length;
        if (len % 2 == 0) {
            return ( helper(A, 0, B, 0, len / 2) + helper(A, 0, B, 0, len / 2 + 1)) / 2.0;
        } else {
            return helper(A, 0, B, 0, len / 2 + 1);
        }
    }
    
    private int helper(int[] A, int Astart, int[] B, int Bstart, int k) {
        if (Astart >= A.length) {
            return B[Bstart + k - 1];
        }
        
        if (Bstart >= B.length) {
            return A[Astart + k - 1];
        }
        
        if (k == 1) {
            return Math.min(A[Astart], B[Bstart]);
        }
        
        int A_key;
        if (Astart + k / 2 - 1 < A.length) {
            A_key = A[Astart + k / 2 - 1];
        } else {
            A_key = Integer.MAX_VALUE;
        }
        int B_key;
        if (Bstart + k / 2 - 1 < B.length) {
            B_key = B[Bstart + k / 2 - 1];
        } else {
            B_key = Integer.MAX_VALUE;
        }
        
        if (A_key <= B_key) {
            return helper(A, Astart + k / 2, B, Bstart, k - k / 2);
        } else {
            return helper(A, Astart, B, Bstart + k / 2, k - k / 2);
        }
    }
}