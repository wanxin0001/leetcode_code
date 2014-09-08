/*
Remove Element Total Accepted: 23084 Total Submissions: 69145 My Submissions
Given an array and a value, remove all instances of that value in place and return the new length.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.
*/

public class Solution {
    public int removeElement(int[] A, int elem) {
        if (A == null || A.length == 0 ) {
            return 0;
        }
        
        int i = 0;
        int ptr = A.length - 1;
        while (i <= ptr) {
            if (A[i] == elem) {
                A[i] = A[ptr];
                ptr--;
            } else {
                i++;
            }
        }
        return ptr + 1;
    }
}