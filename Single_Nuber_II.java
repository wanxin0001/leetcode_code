/*
Single Number II Total Accepted: 21809 Total Submissions: 64837 My Submissions
Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/
public class Solution {
    public int singleNumber(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int[] array = new int[32];
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < A.length; j++) {
                array[i] += (A[j] >> i & 1); 
            }
            
            array[i] %= 3;
            result |= array[i] << i; 
        }
        
        return result;
    }
}