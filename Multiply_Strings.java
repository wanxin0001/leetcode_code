/*
Multiply Strings Total Accepted: 13188 Total Submissions: 64286 My Submissions
Given two numbers represented as strings, return multiplication of the numbers as a string.

Note: The numbers can be arbitrarily large and are non-negative.
*/

public class Solution {
    public String multiply(String num1, String num2) {
        if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) {
            return "";
        }
        
        char[] first = num1.toCharArray();
        char[] second = num2.toCharArray();
        int[] result = new int[first.length + second.length];
        for (int i = second.length - 1; i >= 0; i--) {
            for (int j = first.length - 1; j >= 0; j--) {
                result[i + j + 1] += (second[i] - '0') * (first[j] - '0');
            }
        }
        
        int count = 0;
        for (int i = result.length - 1; i >=0; i--) {
            int total = result[i] + count;
            if (total > 9) {
                count = total / 10;
                result[i] = total % 10;
            } else {
                result[i] = total;
                count = 0;
            }
            
        }
        
        
        int pos = -1;
        for(int i = 0; i < result.length; i++) {
            if (result[i] != 0) {
                pos = i;
                break;
            }
        }
        
        if (pos == -1) {
            return "0"; //Notice
        } else {
            String str = "";
            for (int i = pos; i < result.length; i++) {
                str += Character.toString((char)('0' + result[i]));   
            }
            
            return str;
        }
        
    }
}