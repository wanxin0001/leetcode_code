/*
s One Total Accepted: 18194 Total Submissions: 57616 My Submissions
Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
*/

public class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return null;
        }
        
        int len = digits.length;
        int[] result = new int[len];
        int carry = 1;//Notice: we need to plus 1;
        for (int i = len - 1; i >= 0; i--) {
            if (carry + digits[i] >= 10) {
                carry = 1;
                result[i] = (carry + digits[i]) % 10;
            } else {
                result[i] = (digits[i] + carry) ;
                carry = 0;
            }
              
        }
        
        if (carry == 0) {
            return result;
        } else {
            int[] newResult = new int[len + 1];
            for (int i = 0; i < len; i++) {
                newResult[i + 1] = result[i];
            }
            newResult[0] = 1;
            
            return newResult;
        }
    }
}