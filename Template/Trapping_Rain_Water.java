/*
Trapping Rain Water Total Accepted: 15698 Total Submissions: 54555 My Submissions
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
*/

public class Solution {
    public int trap(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int max = -1;
        int maxIndex = -1;
        int sum = 0;
        int prev;
        
        for (int i = 0; i < A.length; i++) {
            if (max < A[i]) {
                max = A[i];
                maxIndex = i;
            }
        }
        
        prev = 0;
        
        for (int i = 0; i < maxIndex; i++) {
            if (A[i] > prev) {
                sum += (maxIndex - i) * (A[i] - prev);
                prev = A[i];
            }
            
            sum -= A[i];
        }
        
        prev = 0;
        for (int i = A.length - 1; i > maxIndex; i--) {
            if (A[i] > prev) {
                sum += (i - maxIndex) * (A[i] - prev);
                prev = A[i];
            }
            
            sum -= A[i];
        }
        
        return sum;
    }
}