/*
Maximum Subarray Total Accepted: 23823 Total Submissions: 70542 My Submissions
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.

click to show more practice.

More practice:
If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
*/

public class Solution {
    public int maxSubArray(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int max = Integer.MIN_VALUE;
        int sum = 0;
        
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            max = Math.max(sum, max);// Please notice the order
            sum = Math.max(sum, 0);// Please notice the order    In this order, if all values are negative, it can choose the largest one;
            
        }
        
        return max;
    }
}