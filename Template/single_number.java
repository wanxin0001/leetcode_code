/*
Single Number Total Accepted: 29830 Total Submissions: 65215 My Submissions
Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/

public class Solution {
    public int singleNumber(int[] A) {
        int result = 1;
        for (int i = 0; i< A.length; i++) {
            if (i == 0) {
                result = A[i];
            } else {
                result ^=A[i];
            }
                
        }
        return result;
    }
}