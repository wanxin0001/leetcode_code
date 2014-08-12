/*
Merge Sorted Array Total Accepted: 19377 Total Submissions: 60556 My Submissions
Given two sorted integer arrays A and B, merge B into A as one sorted array.

Note:
You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.


*/
public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        if (n == 0) {
            return;
        }
        if (m == 0) {
            System.arraycopy(B, 0, A, 0, n);
            return;
        }
        int aPtr = m - 1;
        int bPtr = n - 1;
        int ptr = m + n - 1;
        
        while(aPtr >= 0 && bPtr >= 0) {
            if (A[aPtr] > B[bPtr]) {
                A[ptr--] = A[aPtr--];
            } else {
                A[ptr--] = B[bPtr--];
            }
            
        }
        
        if (bPtr != -1) {//NOTICE: IS -1, RATHER THAN 0
            System.arraycopy(B,0, A, 0, bPtr + 1);
        }
        
        return;
    }
}